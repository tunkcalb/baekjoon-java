import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		for (int i = 0; i <= 100; i++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] > i && !visited[r][c]) {
						bfs(r, c, i);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	private static void bfs(int row, int col, int height) {

		visited[row][col] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));

		while (!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] || board[nr][nc] <= height)
					continue;
				q.offer(new Point(nr, nc));
				visited[nr][nc] = true;
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
