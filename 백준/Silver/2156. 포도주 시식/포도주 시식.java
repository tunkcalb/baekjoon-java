import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[] dp;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		nums = new int[N + 1];
		
		dp = new Integer[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		dp[0] = 0;
		dp[1] = nums[1];
		if(N > 1) {
			dp[2] = nums[1] + nums[2];			
		}
		
		System.out.println(dfs(N));
	}

	private static int dfs(int n) {
		
		if(dp[n] == null) {
			dp[n] = Math.max(Math.max(dfs(n - 2), dfs(n - 3) + nums[n - 1] ) + nums[n], dfs(n - 1));
		}
		
		return dp[n];
	}
}
