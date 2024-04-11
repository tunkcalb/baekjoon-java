import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N + 1];
		int[] dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i ; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + nums[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
