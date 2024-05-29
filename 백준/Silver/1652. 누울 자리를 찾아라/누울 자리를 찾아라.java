import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		char[][] board = new char[n + 1][n + 1];
		
		int horizon = 0;
		int vertical = 0;
		
		for(int i = 0; i < n; i++) {
			String line = in.readLine();
			for(int j = 0; j < n; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			int hCnt = 0;
			int vCnt = 0;
			
			for(int j = 0; j < n; j++) {
				if(board[i][j] == '.') hCnt++;
				if(board[i][j] == 'X' || (j == n - 1)) {
					if(hCnt >= 2) horizon++;
					hCnt = 0;
				}
				
				if(board[j][i] == '.') vCnt++;
				if(board[j][i] == 'X' || (j == n - 1)) {
					if(vCnt >= 2) vertical++;
					vCnt = 0;
				}
			}
		}
		System.out.println(horizon + " " + vertical);
	}
}
