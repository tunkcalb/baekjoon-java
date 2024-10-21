import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			String line = in.readLine();
			for(int j = 1; j <= m; j++) {
				board[i][j] = line.charAt(j - 1) - '0';
			}
		}
		
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dp[i][j] = board[i][j];
				if(dp[i][j] == 1 && max == 0) max = 1;
				if(dp[i][j] == 1 && dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0) {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]))  + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		System.out.println(max * max);
	}
}
