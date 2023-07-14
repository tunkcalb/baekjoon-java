import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r;
		int c;
		int cnt;
		char what;
		
		public Point(int r, int c, int cnt, char what) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.what = what;
		}
	}

	static int R, C;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static boolean[][] visited;
	static int[][] board;
	static List<Point> fires = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int row = 0;
		int col = 0;
		board = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				char blank = line.charAt(j);
				if (blank == '#') {
					board[i][j] = 1;
				} else if (blank == 'J') {
					board[i][j] = 0;
					row = i;
					col = j;
				} else if (blank == 'F'){
					fires.add(new Point(i, j, 1, 'F'));
					board[i][j] = 3;
				} else board[i][j] = 0;
			}
		}

		int cnt = bfs(row, col);

		if (cnt == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(cnt);
		}

	}

	private static int bfs(int row, int col) {
		
		Queue<Point> q = new LinkedList<>();
		
		for(Point fire : fires) {
			q.offer(fire);
		}
		q.offer(new Point(row, col, 1, 'J'));
		visited[row][col] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			char what = now.what;
			if(what == 'J' && (r == R - 1 || c == C - 1 || r == 0 || c == 0)) {
				return cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == 1 || visited[nr][nc] || board[nr][nc] == 3) continue;
				
				if(what == 'J') {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, cnt + 1, what));
				}
				else {
					board[nr][nc] = 3;
					q.offer(new Point(nr, nc, cnt + 1, what));
				}
				
			}
		}
		
		return -1;
	}
}
