import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		dp = new int[N + 1][N + 1];
		dp[2][1] = 2;
		
		for(int i = 3; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 10007;
			}
		}
		
		int sum = 0;
		for(int i = 1; i < N; i++) {
			sum += dp[N][i];
		}
		sum %= 10007;
		System.out.println(sum);
	}
}
