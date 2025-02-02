import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int[][] dp;
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				int num = board[i][j];
				dp[i][j] = Math.max(dp[i - 1][j] + num, dp[i][j - 1] + num);
			}
		}
		System.out.println(dp[N][M]);
	}
}
