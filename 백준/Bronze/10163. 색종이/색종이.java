import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = 1001;
		int[][] board = new int[M][M];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			for(int r = r1; r < r1 + r2; r++) {
				for(int c = c1; c < c1 + c2; c++) {
					board[r][c] = i;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			
			for(int r = 0; r < M; r++) {
				for(int c = 0; c < M; c++) {
					if(board[r][c] == i) sum++;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
