import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] nums;
	static int[] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N + 1];
		dp = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dp, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[N] = 0;
		
		for(int i = 1; i <= N - 1; i++) {
			visited[i] = true;
			dp[i] = find(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(dp[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int find(int i) {
		if(dp[i] != -1) return dp[i];
		
		if(!visited[nums[i]]) {
			visited[nums[i]] = true;
			int next = find(nums[i]);
			if(next != -1) {
				return dp[i] = find(nums[i]) + 1;				
			}
			else return -1;
		}
		
		if(dp[nums[i]] != -1) {
			return dp[i] = dp[nums[i]] + 1;
		}
		
		return -1;
	}
}
