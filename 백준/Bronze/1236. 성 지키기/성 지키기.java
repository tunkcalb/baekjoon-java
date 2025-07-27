import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		int[][] board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				char now = line.charAt(j);
				board[i][j] = now == '.' ? 0 : 1;
			}
		}
		
		int row = 0;
		count: for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 1) {
					continue count;
				}
			}
			row++;
		}
		
		int col = 0;
		
		count: for(int j = 0; j < M; j++) {
			for(int i = 0; i < N; i++) {
				if(board[i][j] == 1) {
					continue count;
				}
			}
			col++;
		}
		
		System.out.println(Math.max(row, col));
	}
}
