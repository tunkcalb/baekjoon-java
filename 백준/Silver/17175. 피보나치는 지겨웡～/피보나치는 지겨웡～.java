import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 50;
		
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		int m = 1000000007;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % m + 1;
		}
		
		int num = Integer.parseInt(in.readLine());
		
		System.out.println(dp[num]);
	}
}
