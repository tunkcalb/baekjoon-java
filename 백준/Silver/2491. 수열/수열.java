import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] nums = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[2][N + 1];
		dp[0][1] = 1;
		dp[1][1] = 1;
		
		int max = 1;
		
		for(int i = 2; i <= N; i++) {
			if(nums[i] >= nums[i - 1]) {
				dp[0][i] = dp[0][i - 1] + 1;
			}
			else dp[0][i] = 1;
			if(nums[i] <= nums[i - 1]) {
				dp[1][i] = dp[1][i - 1] + 1;
			}
			else dp[1][i] = 1;
			max = Math.max(max, dp[0][i]);
			max = Math.max(max, dp[1][i]);
		}
		System.out.println(max);
	}
}
