import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int m = 116;
		
		long[] dp = new long[m + 1];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i = 4; i <= m; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}
		
		System.out.println(dp[n]);
	}
}
