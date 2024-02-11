import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H;
	static int cnt;
	static int[][][] board;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static Queue<Point> q;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[M][N][H];
		visited = new boolean[M][N][H];
		q = new LinkedList<>();
		cnt = 0;
		for (int k = 0; k < H; k++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int i = 0; i < M; i++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 0) cnt++;
					if (board[i][j][k] == 1) {
						q.offer(new Point(i, j, k));
						visited[i][j][k] = true;
					}
				}
			}
		}

		if (cnt == 0) {
			System.out.println(0);
		} else {
			System.out.println(bfs());
		}

	}

	private static int bfs() {
		int day = 0;

		while (!q.isEmpty()) {
			if(cnt == 0) break;
			int size = q.size();
			day++;
			for (int s = 0; s < size; s++) {
				Point now = q.poll();
				int x = now.x;
				int y = now.y;
				int z = now.z;

				for (int i = 0; i < 6; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					int nz = now.z + dz[i];

					if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H)
						continue;
					if (visited[nx][ny][nz])
						continue;
					if(board[nx][ny][nz] == -1) continue;

					visited[nx][ny][nz] = true;
					q.offer(new Point(nx, ny, nz));
					cnt--;
				}
			}
		}

		if (cnt > 0) {
			day = -1;
		}
		return day;
	}

	static class Point {
		int x;
		int y;
		int z;

		Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
