import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[][] board;
	private static int x1;
	private static int y1;
	private static int x2;
	private static int y2;
	private static int num;

	private static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		/**
		 * 1. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N + 1][N + 1];

		/**
		 * 2. 입력파일 객체화
		 */
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = board[i][j - 1] + Integer.parseInt(st.nextToken());

			}
		}

		/**
		 * 3. 알고리즘 풀기
		 */
		for (int i = 0; i < M; i++) {
			int num = 0;
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int j = x1; j < x2 + 1; j++) {
				num += board[j][y2] - board[j][y1 - 1];
			}
			sb.append(num).append("\n");
		}
		/**
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
}