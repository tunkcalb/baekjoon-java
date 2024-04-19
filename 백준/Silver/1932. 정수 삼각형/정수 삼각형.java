import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] dp = new int[n + 1][n + 1];
		int[][] board = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= i; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + board[i][j];
			}
		}
		
		int ans = 0;
		
		for(int i = 1; i <= n; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
	}
}
