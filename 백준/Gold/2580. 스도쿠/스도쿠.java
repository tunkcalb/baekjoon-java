import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = 9;
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
	}

	private static void dfs(int r, int c) {
		
		if(c == N) {
			dfs(r + 1, 0);
			return;
		}
		
		if(r == N) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(board[r][c] == 0) {
			for(int i = 1; i <= N; i++) {
				if(possible(r, c, i)) {
					board[r][c] = i;
					dfs(r, c + 1);
				}
			}
			board[r][c] = 0;
			return;
		}
		dfs(r, c + 1);
	}

	private static boolean possible(int r, int c, int val) {

		for(int i = 0; i < N; i++) {
			if(board[r][i] == val || board[i][c] == val) return false;
		}
		
		r /= 3;
		r *= 3;
		c /= 3;
		c *= 3;
		
		for(int i = r; i < r + 3; i++) {
			for(int j = c;  j < c + 3; j++) {
				if(board[i][j] == val) return false;
			}
		}
		return true;
	}
}
