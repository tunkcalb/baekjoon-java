import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int N = 250;
		
		BigInteger[] dp = new BigInteger[N + 1];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
		}
		
		StringBuilder sb = new StringBuilder();
		while((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}
