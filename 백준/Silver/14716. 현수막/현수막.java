import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dr = {-1, 1, -1, -1, 1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int row, int col) {
		
		Queue<Point> q = new LinkedList<>();
		visited[row][col] = true;
		q.add(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(board[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));
			}
		}
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
