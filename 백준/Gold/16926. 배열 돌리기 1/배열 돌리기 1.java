import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			revolve(board);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(board[i][j]);
				if(j != M - 1) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void revolve(int[][] board) {
		int time = Math.min(N, M) / 2;
		for(int i = 0; i < time; i++) {
			int startR = i;
			int startC = i;
			int endR = N - i - 1;
			int endC = M - i - 1;
			int temp = board[i][i];
			
			for(int j = startC; j < endC; j++) {
				board[startR][j] = board[startR][j + 1];
			}
			
			for(int j = startR; j < endR; j++) {
				board[j][endC] = board[j + 1][endC];
			}
			
			for(int j = endC; j > startC; j--) {
				board[endR][j] = board[endR][j - 1];
			}
			
			for(int j = endR; j > startR ; j--) {
				board[j][startC] = board[j - 1][startC];
			}
			board[startR + 1][startC] = temp;
		}
		return;
	}
}
