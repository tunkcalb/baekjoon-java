import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 30;
		
		long[][] dp = new long[N + 1][N + 1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				if(j > i) continue;
				else if(j == 0) dp[i][j] = 1;
				else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0) break;
			sb.append(dp[n][n]).append("\n");			
		}
		
		System.out.println(sb);
	}
}
