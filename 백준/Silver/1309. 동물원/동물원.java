import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int mod = 9901;
		
		int[][] dp = new int[N + 1][2 + 1];
		for(int i = 0; i < 3; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
		}
		
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);
	}
}
