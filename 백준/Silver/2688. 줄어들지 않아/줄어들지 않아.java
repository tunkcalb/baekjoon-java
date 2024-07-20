import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		long[][] dp = new long[64 + 1][10];
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= 64; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = j; k <= 9; k++) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			long ans = 0;
			
			for(int i = 0; i <= 9; i++) {
				ans += dp[N][i];
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
