import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= M; j++) {
				board[i][j] = board[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int row1 = Integer.parseInt(st.nextToken());
			int col1 = Integer.parseInt(st.nextToken());
			int row2 = Integer.parseInt(st.nextToken());
			int col2 = Integer.parseInt(st.nextToken());
			
			int sum = cal(row1, col1, row2, col2);
			
			System.out.println(sum);
		}
	}

	private static int cal(int row1, int col1, int row2, int col2) {
		int sum = 0;
		
		for(int i = row1; i <= row2; i++) {
			sum += board[i][col2] - board[i][col1 - 1];
		}
		
		return sum;
	}
}
