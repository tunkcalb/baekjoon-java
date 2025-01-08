import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int[][] dp;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				char num = line.charAt(j);
				if(num == 'H') board[i][j] = 0;
				else board[i][j] = num - '0';
			}
		}
		
		max = 1;
		visited[0][0] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt) {
		if(max < cnt) {
			max = cnt;
		}
		dp[r][c] = cnt;
		
		int gap = board[r][c];
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i] * gap;
			int nc = c + dc[i] * gap;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 0) continue;
			if(visited[nr][nc]) {
				System.out.println(-1);
				System.exit(0);
			}
			if(dp[nr][nc] > cnt) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1);
			visited[nr][nc] = false;
		}
	}
}
