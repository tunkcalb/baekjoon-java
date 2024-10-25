import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] board;
	static int[][] ans;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		ans = new int[n][m];
		visited = new boolean[n][m];
		int r = 0;
		int c = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			Arrays.fill(ans[i], -1);
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					r = i;
					c = j;
				}
				if(board[i][j] == 0) {
					ans[i][j] = 0;
				}
			}
		}
		
		bfs(r, c);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int row, int col) {
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(row, col, 0));
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			int d = now.d;
			ans[r][c] = d;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if(visited[nr][nc] || board[nr][nc] == 0) continue;

				visited[nr][nc] = true;
				q.offer(new Point(nr, nc, d + 1));
			}
		}
		
	}
	
	static class Point {
		int r;
		int c;
		int d;
		
		Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
