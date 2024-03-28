import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int num = Integer.parseInt(in.readLine());
		int a = 0;
		int b = 0;

		int r = 0;
		int c = 0;
		int dir = 0;

		int[][] board = new int[N][N];

		for (int i = N * N; i > 0; i--) {
			board[r][c] = i;
			if (i == num) {
				a = r;
				b = c;
			}

			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < N && nr >= 0 && nc < N && nc >= 0 && board[nr][nc] == 0) {
				r = nr;
				c = nc;
			}
			else {
				dir = (dir + 1) % 4;
				r += dr[dir];
				c += dc[dir];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(a + 1).append(" ").append(b + 1);
		System.out.println(sb);
	}
}
