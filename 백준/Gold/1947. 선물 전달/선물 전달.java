import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		long M = 1000000000;
		
		long[] dp = new long[N + 1];
		
		if(N >= 2) dp[2] = 1;
		for(int i = 3; i <= N; i++) {
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % M;
		}
		
		System.out.println(dp[N]);
	}
}
