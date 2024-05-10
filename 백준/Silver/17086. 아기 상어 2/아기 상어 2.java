import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int distance = bfs(i, j);
				max = Math.max(max, distance);
			}
		}
		System.out.println(max);
	}

	static int bfs(int row, int col) {
		int distance = 0;
		boolean[][] visited = new boolean[N][M];

		Queue<Point> q = new LinkedList<>();

		visited[row][col] = true;
		q.offer(new Point(row, col));

		while (!q.isEmpty()) {
			int size = q.size();

			for (int j = 0; j < size; j++) {
				Point now = q.poll();
				int r = now.r;
				int c = now.c;
				
				if(board[r][c] == 1) return distance;
				
				for (int i = 0; i < 8; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (visited[nr][nc])
						continue;
					
					visited[nr][nc] = true;
					q.offer(new Point(nr ,nc));
				}

			}
			distance++;
		}

		return distance;
	}
}

class Point {
	int r;
	int c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
