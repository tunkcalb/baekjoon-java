import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == '1') board[i][j] = true;
			}
		}
		
		int cnt = 0;
		for(int i = N - 1; i >= 0; i--) {
			for(int j = M - 1; j >= 0; j--) {
				if(board[i][j]) {
					reverse(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void reverse(int n, int m) {
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				board[i][j] = !board[i][j];
			}
		}
	}
}
