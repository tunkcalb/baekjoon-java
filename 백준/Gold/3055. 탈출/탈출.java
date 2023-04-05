import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int r;
		int c;
		int cnt;
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int R, C;
	static int r, c;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i = 0; i < R; i++) {
			String line = in.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'S') {
					r = i;
					c = j;
				}
			}
		}
		
		int ans = bfs();
		if(ans == 0) {
			System.out.println("KAKTUS");
		}else System.out.println(ans);
	}

	private static int bfs() {
		boolean[][] visited = new boolean[R][C];
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r, c, 0));
		while(!q.isEmpty()) {
			water();
			int qSize = q.size();
			
			for(int i = 0; i < qSize; i++) {
				
				Point now = q.poll();
				
				int r = now.r;
				int c = now.c;
				int cnt = now.cnt;
				if(board[r][c] == 'D') {
					return cnt;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && board[nr][nc] != '*' && board[nr][nc] != 'X') {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, cnt + 1));
					}
				}
			}
		}
		
		return 0;
	}

	private static void water() {
		char[][] copy = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				copy[i][j] = board[i][j];
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] == '*') {
					visited[i][j] = true;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && board[nr][nc] != 'D' && board[nr][nc] != 'X') {
							visited[nr][nc] = true;
							copy[nr][nc] = '*';
						}
					}
				}
			}
		}

		board = copy;
	}
}