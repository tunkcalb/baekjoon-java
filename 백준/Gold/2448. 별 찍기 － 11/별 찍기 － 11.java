import java.io.*;
import java.util.*;

public class Main {	
	
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		board = new char[N][2 * N - 1];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(board[i], ' ');
		}
		
		
		draw(N, 0, N - 1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(board[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void draw(int n, int x, int y) {
		
		if(n == 3) {
			board[x][y] = '*';
			board[x + 1][y - 1] = '*';
			board[x + 1][y + 1] = '*';
			
			for(int i = -2; i <= 2; i++) {
				board[x + 2][y + i] = '*';
			}
			return;
		}
		
		int half = n / 2;
		draw(half, x, y);
        draw(half, x + half, y - half);
        draw(half, x + half, y + half);
	}
}
