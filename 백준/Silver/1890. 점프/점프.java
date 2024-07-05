import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N][N];
		dp[0][0] = (long) 1;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(r == N - 1 && c == N - 1) break;
				int num = board[r][c];
				for(int i = 0; i < 2; i++) {
					int nr = r + dr[i] * num;
					int nc = c + dc[i] * num;
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					dp[nr][nc] += dp[r][c];
				}
				
			}
		}
		
		System.out.println(dp[N - 1][N - 1]);
	}
}
