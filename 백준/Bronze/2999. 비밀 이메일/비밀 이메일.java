import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		int len = line.length();
		
		int m = (int) Math.sqrt(len);
		
		int n = 0;
		for(int i = m; i >= 0; i--) {
			if(len % i == 0) {
				n = i;
				break;
			}
		}
		
		m = len / n;
		String[][] board = new String[n][m];
		
		int idx = 0;
		for(int j = 0; j < m; j++) {
			for(int i = 0; i < n; i++) {
				board[i][j] = String.valueOf(line.charAt(idx++));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(board[i][j]);
			}
		}
		System.out.println(sb.toString());
	}
}
