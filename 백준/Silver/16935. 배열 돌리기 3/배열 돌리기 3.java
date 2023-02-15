import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] board;
	private static int N;
	private static int M;
	private static int R;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;

			}

		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void func1() {
		N = board.length;
		M = board[0].length;
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = board[N - 1 - i][j];
			}
		}
		
		board = temp;
	}

	private static void func2() {
		N = board.length;
		M = board[0].length;
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = board[i][M - 1 - j];
			}
		}
		
		board = temp;
	}

	private static void func3() {
		N = board.length;
		M = board[0].length;
		int[][] temp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = board[N - 1 - j][i];
			}
		}
		
		board = temp;
	}

	private static void func4() {
		N = board.length;
		M = board[0].length;
		int[][] temp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = board[j][M - 1 - i];
			}
		}
		
		board = temp;
	}

	private static void func5() {
		N = board.length;
		M = board[0].length;
		int[][] temp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = board[i + N / 2][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j] = board[i][j - M / 2];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = board[i][j + M / 2];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j] = board[i - N / 2][j];
			}
		}
		board = temp;
	}

	private static void func6() {
		N = board.length;
		M = board[0].length;
		int[][] temp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = board[i][j + M / 2];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j] = board[i + N / 2][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = board[i - N / 2][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j] = board[i][j - M / 2];
			}
		}
		board = temp;
	}

}