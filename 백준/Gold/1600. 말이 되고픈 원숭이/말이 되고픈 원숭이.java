import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r;
		int c;
		int cnt;
		int k;

		public Point(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}

	}

	static int K, W, H;

	static int[] horser = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] horsec = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] monkeyr = { -1, 1, 0, 0 };
	static int[] monkeyc = { 0, 0, -1, 1 };

	static int[][] board;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = move();
		System.out.println(ans);

	}

	private static int move() {
		Queue<Point> q = new ArrayDeque<>();

		visited[0][0][K] = true;
		q.offer(new Point(0, 0, 0, K));

		while (!q.isEmpty()) {

			Point now = q.poll();

			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			int k = now.k;

			if (r == H - 1 && c == W - 1) return cnt;

			for (int i = 0; i < 4; i++) {
				int nr = r + monkeyr[i];
				int nc = c + monkeyc[i];

				if (nr >= 0 && nr < H && nc >= 0 && nc < W && board[nr][nc] == 0 && !visited[nr][nc][k]) {
					visited[nr][nc][k] = true;
					q.offer(new Point(nr, nc, cnt + 1, k));
				}
			}
			if (k > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = r + horser[i];
					int nc = c + horsec[i];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && board[nr][nc] == 0 && !visited[nr][nc][k - 1]) {
						visited[nr][nc][k - 1] = true;
						q.offer(new Point(nr, nc, cnt + 1, k - 1));
					}
				}
			}

		}
		return -1;
	}
}