import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		
		dp = new long[68];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(koong(n));
		}
	}

	private static long koong(int n) {
		
		if(dp[n] == 0) {
			dp[n] = koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
		}
		return dp[n];
	}
}
