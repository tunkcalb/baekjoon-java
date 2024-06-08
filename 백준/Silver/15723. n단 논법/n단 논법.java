import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int size = 26;
		int[][] board = new int[size][size];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			int b = st.nextToken().charAt(0) - 'a';
			
			board[a][b] = 1;
		}
		
		for(int k = 0; k < size; k++) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(board[i][k] != 0 && board[k][j] != 0) board[i][j] = 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(in.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			int b = st.nextToken().charAt(0) - 'a';
			if(board[a][b] == 0) sb.append("F").append("\n");
			else sb.append("T").append("\n");
			}
		System.out.println(sb);
	}
}
