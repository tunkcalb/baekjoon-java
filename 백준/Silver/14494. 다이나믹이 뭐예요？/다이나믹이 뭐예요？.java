import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n + 1][m + 1];
		board[1][1] = 1;
		int mod = 1000000007;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				board[i][j] += board[i - 1][j];
				board[i][j] %= mod;
				board[i][j] += board[i][j - 1];
				board[i][j] %= mod;
				board[i][j] += board[i - 1][j - 1];
				board[i][j] %= mod;
			}
		}
		
		System.out.println(board[n][m]);
	}
}
