import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(in.readLine());
		int M = 10;
		int[][] dp = new int[N + 1][M];
		for(int i = 0; i < M; i++) {
			dp[0][i] = 1;
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = j; k < M; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(dp[N][0]);
	}
}
