import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int min;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 2;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 1) {
					dfs(i, j, num++);
				}
			}
		}
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] != 0) {
					bfs(i, j, board[i][j]);
				}
			}
		}
		System.out.println(min - 1);
	}

	private static void bfs(int row, int col, int num) {
		boolean[][] visited = new boolean[N][N];
		
		Queue<Point> q = new LinkedList<>();
		visited[row][col] = true;
		q.offer(new Point(row, col, 0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			if(board[r][c] != 0 && board[r][c] != num) {
				min = Math.min(min, cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(board[nr][nc] == num || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc, cnt + 1));
			}
		}
	}

	private static void dfs(int r, int c, int num) {
		board[r][c] = num;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(board[nr][nc] != 1) continue;
			dfs(nr, nc, num);
		}
	}
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
