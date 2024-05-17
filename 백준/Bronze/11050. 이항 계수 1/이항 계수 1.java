import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
	}

	private static int factorial(int n) {
		if(dp[n] != 0) return dp[n];
		dp[n] = n * factorial(n - 1);
		return dp[n];
	}
}
