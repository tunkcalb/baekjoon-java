import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int n, m;
	static int cnt, maxSize;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		maxSize = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxSize);
		
	}

	private static void bfs(int row, int col) {
		
		Queue<Point> q = new LinkedList<>();
		
		visited[row][col] = true;
		q.offer(new Point(row, col));
		int size = 1;
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			
			if(maxSize < size) maxSize = size;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || board[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				size++;
				q.offer(new Point(nr, nc));
			}
		}
		
		
	}
	
	static class Point {
		int r;
		int c;
		int size;
		
		Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
