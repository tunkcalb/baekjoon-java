import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] visited;
	static char[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		int wolfSize = 0;
		int sheepSize = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'v')
					wolfSize++;
				if (board[i][j] == 'o')
					sheepSize++;
			}
		}
		sb.append(sheepSize).append(" ").append(wolfSize);
		System.out.println(sb);
	}

	static void bfs(int row, int col) {
		List<Point> wolf = new ArrayList<>();
		List<Point> sheep = new ArrayList<>();

		visited[row][col] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		if (board[row][col] == 'v')
			wolf.add(new Point(row, col));
		if (board[row][col] == 'o')
			sheep.add(new Point(row, col));

		while (!q.isEmpty()) {
			Point now = q.poll();

			int r = now.r;
			int c = now.c;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				char word = board[nr][nc];
				if (word == '#' || visited[nr][nc])
					continue;
				Point next = new Point(nr, nc);

				if (word == 'v')
					wolf.add(next);
				if (word == 'o')
					sheep.add(next);
				q.offer(next);
				visited[nr][nc] = true;
			}
		}
		int wolfSize = wolf.size();
		int sheepSize = sheep.size();

		if (wolfSize < sheepSize) remove(wolf);
		else remove(sheep);
	}

	static void remove(List<Point> animal) {
		for (Point now : animal) {
			int r = now.r;
			int c = now.c;

			board[r][c] = '.';
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
