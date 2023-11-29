import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][2];
		
		int min = -200000000;
		int max = min;
		dp[0][0] = min;
		dp[0][1] = min;
		
		for(int i = 1; i <= N; i++) {
			dp[i][0] = min;
			dp[i][1] = min;
			dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(max);
	}
}
