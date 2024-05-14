import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(in.readLine());
			int[][] board = new int[N + 1][2];
			
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(in.readLine());
				for(int i = 1; i <= N; i++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			
			int[][] dp = new int[N + 1][2];

			dp[1][0] = board[1][0];
			dp[1][1] = board[1][1];
			
			for(int i = 2; i <= N; i++) {
				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][0]);
				dp[i][0] = Math.max(dp[i][0], dp[i - 2][1]) + board[i][0];
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][1]);
				dp[i][1] = Math.max(dp[i][1], dp[i - 2][0]) + board[i][1];
			}
			sb.append(Math.max(dp[N][0], dp[N][1])).append("\n");
		}
		System.out.println(sb);
	}
}
