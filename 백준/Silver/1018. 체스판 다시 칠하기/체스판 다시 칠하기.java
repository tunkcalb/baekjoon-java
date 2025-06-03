import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] board;
	static int min = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == 'W') {
					board[i][j] = true;
				}
			}
		}
		
		int N_row = N - 7;
		int M_col = M - 7;
		
		for(int i = 0; i < N_row; i++) {
			for(int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);
		
	}

	private static void find(int r, int c) {
		int end_r = r + 8;
		int end_c = c + 8;
		int cnt = 0;
		
		boolean color = board[r][c];
		
		for(int i = r; i < end_r; i++) {
			for(int j = c; j < end_c; j++) {
				if(board[i][j] != color) cnt++;
				
				color = !color;
			}
			color = !color;
		}
		
		cnt = Math.min(cnt,  64 - cnt);
		
		min = Math.min(min, cnt);
	}
}
