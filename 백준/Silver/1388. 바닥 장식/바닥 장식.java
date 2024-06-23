import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static char[][] board;
	static boolean[][] visited;
	static int cnt;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) bfs(i, j);
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int row, int col) {
		
		Queue<Point> q = new LinkedList<>();
		visited[row][col] = true;
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 2; i++) {
				int nc = 0;
				int nr = 0;
				if(board[r][c] == '-') {
					nr = r + dr[i + 2];
					nc = c + dc[i + 2];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
					if(board[nr][nc] != '-') continue;
				}
				if(board[r][c] == '|') {
					nr = r + dr[i];
					nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
					if(board[nr][nc] != '|') continue;
				}
				
				
				
				q.offer(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}
		
		cnt++;
	}
	
	static class Point{
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
