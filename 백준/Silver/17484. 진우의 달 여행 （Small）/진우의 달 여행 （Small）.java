import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int min;
	static int[] dr = {1, 1, 1};
	static int[] dc = {-1, 0, 1};
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int j = 0; j < M; j++) {
			dfs(0, j, board[0][j], -1);
		}
		
		System.out.println(min);
	}

	private static void dfs(int row, int col, int sum, int dir) {
		if(row == N - 1) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0 ; i < 3; i++) {
			
			if(i == dir) continue;
			
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nc < 0 || nc >= M) continue;
			
			dfs(nr, nc, sum + board[nr][nc], i);
		}
		
	}
}
