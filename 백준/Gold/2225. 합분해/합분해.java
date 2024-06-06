import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int mod;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mod = 1000000000;
		dp = new int[N + 1][K + 1];
		
		for(int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		
		for(int i = 0; i <= K; i++) {
			dp[1][i] = i;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
