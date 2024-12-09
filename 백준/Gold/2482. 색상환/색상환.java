import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int mod = 1000000003;
		
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		
		int[][] dp = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}
		
		for(int i = 3; i <= N; i++) {
			for(int j = 2; j <= (i + 1) / 2; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % mod;
			}
		}
		int ans = dp[N - 3][K - 1] + dp[N - 1][K];
		ans %= mod;
		
		System.out.println(ans);
	}
}
