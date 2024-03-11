import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long[] dp = new long[80 + 1];
		
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[N] * 4 + dp[N - 1] * 2);
	}
}
