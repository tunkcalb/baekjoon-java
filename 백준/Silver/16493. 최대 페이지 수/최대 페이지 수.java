import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[M + 1][2];
		int[][] dp = new int[M + 1][N + 1];
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int pages = Integer.parseInt(st.nextToken());
			
			board[i][0] = day;
			board[i][1] = pages;
		}
		
		for(int i = 1; i <= M; i++) {
			int day = board[i][0];
			int pages = board[i][1];
			
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j];
				if((j - day) >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - day] + pages);
				}
			}
		}
		System.out.println(dp[M][N]);
	}
}
