import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int max;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 'L') {
					visited = new boolean[n][m];
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		
		visited[row][col] = true;
		q.add(new Point(row, col, 0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			if(cnt > max) max = cnt;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if(visited[nr][nc] || board[nr][nc] == 'W') continue;
				visited[nr][nc] = true;
				q.add(new Point(nr, nc, cnt + 1));	
			}
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
