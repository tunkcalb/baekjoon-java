import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char[][] board = new char[N][N];
		
		boolean[][] friend = new boolean[N][N];
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 'Y') {
					friend[i][j] = true;
					
					for(int k = 0; k < N; k++) {
						if(board[j][k] == 'Y') {
							friend[i][k] = true;
						}
					}
				}
			}
			
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(friend[i][j]) cnt++;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
