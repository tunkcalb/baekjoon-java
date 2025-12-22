import java.io.*;
import java.util.*;

public class Main {
	
	static int max;
	static int[] nums;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] maxNums = new int[N + 1];
		size = 5;
		for(int i = 1; i <= N; i++) {
			max = 0;
			nums = new int[size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0, 0);
			maxNums[i] = max;
		}
		
		int idx = N;
		int val = 0;
		for(int i = N; i > 0; i--) {
			if(maxNums[i] > val) {
				idx = i;
				val = maxNums[i];
			}
		}
		System.out.println(idx);
	}

	private static void combination(int idx, int cnt, int sum) {
		
		if(cnt == 3) {
			max = Math.max(max, sum % 10);
			return;
		}
		
		for(int i = idx; i < size; i++) {
			combination(i + 1, cnt + 1, sum + nums[i]);
			combination(i + 1, cnt, sum);
		}
	}
}
