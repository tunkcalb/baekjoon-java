import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = 100000;
		int mod = 1000000009;
		long[] dp = new long[m + 1];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		
		for(int i = 7; i <= m; i++) {
			dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % mod;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(in.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb);
	}
}
