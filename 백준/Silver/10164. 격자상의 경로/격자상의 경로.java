import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		int kRow = (K % M == 0) ? K / M : K / M + 1;
		int kCol = (K % M == 0) ? M : K % M;
		
		if(K == 0) {
			kRow = 1;
			kCol = 1;
		}
		
		board[1][1] = 1;
		countPath(1, 1, kRow, kCol);
		countPath(kRow, kCol, N, M);

		System.out.println(board[N][M]);
	}

	private static void countPath(int startR, int startC, int endR, int endC) {

		for (int i = startR; i <= endR; i++) {
			for (int j = startC; j <= endC; j++) {
				if (i > startR)
					board[i][j] += board[i - 1][j];
				if (j > startC)
					board[i][j] += board[i][j - 1];
			}
		}
	}
}
