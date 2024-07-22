import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int[] combination;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = 7;
		
		nums = new int[N + 2];
		combination = new int[N];
		
		for(int i = 0; i < N + 2; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		int idx = 0;
		int cnt = 0;
		dfs(idx, cnt);
	}

	private static void dfs(int idx, int cnt) {
		
		if(cnt == N) {
			int sum = 0;
			
			for(int num : combination) {
				sum += num;
			}
			if(sum == 100) {
				Arrays.sort(combination);
				for(int num : combination) {
					System.out.println(num);
				}
				System.exit(0);
			}
			return;
		}
		
		for(int i = idx; i < N + 2; i++) {
			combination[cnt] = nums[i];
			dfs(i + 1, cnt + 1);
		}
		
	}
}
