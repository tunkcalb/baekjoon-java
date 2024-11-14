import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int max;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt, int sum) {
		
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(visited[nr][nc]) continue;
			if(cnt == 2) {
				visited[nr][nc] = true;
				dfs(r, c, cnt + 1, sum + board[nr][nc]);
				visited[nr][nc] = true;
			}
			
			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1, sum + board[nr][nc]);
			visited[nr][nc] = false;
		}
		
	}
}
