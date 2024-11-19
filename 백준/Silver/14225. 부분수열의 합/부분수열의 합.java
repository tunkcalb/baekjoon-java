import java.io.*;
import java.util.*;

public class Main {
	
	static int size;
	static int N;
	static int[] nums;
	static int[] comb;
	static boolean[] number;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		nums = new int[N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
		}
		
		number = new boolean[sum + 2];
		
		for(int i = 1; i <= N; i++) {
			comb = new int[N];
			size = i;
			combination(0, 0);
		}
		
		for(int i = 1; i <= sum + 1; i++) {
			if(!number[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	private static void combination(int cnt, int idx) {
		
		if(cnt == size) {
			int sum = 0;
			for(int num : comb) {
				sum += num;
			}
			number[sum] = true;
			return;
		}
		
		for(int i = idx; i < N; i++) {
			comb[cnt] = nums[i];
			combination(cnt + 1, i + 1);
		}
	}
}
