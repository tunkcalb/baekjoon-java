import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = 1000000;
		int abs = Math.abs(n);
		int mod = 1000000000;
		
		int[] dp = new int[m + 1];
		dp[1] = 1;
		
		for(int i = 2; i <= m; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dp[i] %= mod;
		}
		
		StringBuilder sb = new StringBuilder();
		if(n < 0) {
			if(abs % 2 == 0) sb.append(-1);
			else sb.append(1);
		} 
		else if (n == 0) sb.append(0);
		else {
			sb.append(1);
		}
		
		sb.append("\n");
		
		sb.append(dp[abs]);
		
		System.out.println(sb);
	}
}
