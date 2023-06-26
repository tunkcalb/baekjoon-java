import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] board;
	static boolean[][][] visited;

	static class Point {
		int r;
		int c;
		int k;
		int cnt;
		boolean day;

		public Point(int r, int c, int k, int cnt, boolean day) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		visited = new boolean[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(0, 0, 0, 1, true));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			int k = now.k;
			int cnt = now.cnt;
			boolean day = now.day;

			if (r == N - 1 && c == M - 1)
				return cnt;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= N || nr < 0 || nc >= M || nc < 0)
					continue;

				if (board[nr][nc] == 0 && !visited[nr][nc][k]) {
					q.offer(new Point(nr, nc, k, cnt + 1, !day));
					visited[nr][nc][k] = true;

				} else if (board[nr][nc] == 1 && k < K) {
					if(day && !visited[nr][nc][k + 1]) {
						visited[nr][nc][k + 1] = true;
						q.offer(new Point(nr, nc, k + 1, cnt + 1, !day));
					}
					else if(!day && !visited[nr][nc][k]) {
						q.offer(new Point(r, c, k, cnt + 1, !day));
					}
				}
			}
		}
		return -1;
	}
}
