import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			board[r][c] = 1;
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(max);
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(visited[nr][nc]) continue;
			if(board[nr][nc] == 0) continue;
			dfs(nr, nc);
		}
	}
}
