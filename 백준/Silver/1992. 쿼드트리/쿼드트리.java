import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			char[] line = in.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				board[i][j] = line[j] - '0';
			}
		}
		
		tree(0, 0, N);
		System.out.println(sb);
		
	}

	private static void tree(int row, int col, int size) {
		int sum = 0;
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				sum += board[i][j];
			}
		}
		
		if(sum == size * size) {
			sb.append(1);
			return;
		}
		if(sum == 0) {
			sb.append(0);
			return;
		}
		
		sb.append("(");
		size = size / 2;
		// 좌상
		tree(row, col, size);
		// 우상
		tree(row, col + size, size);
		// 좌하
		tree(row + size, col, size);
		// 우하
		tree(row + size, col + size, size);
		
		sb.append(")");
	}

}