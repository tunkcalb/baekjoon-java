import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 2000;
		int T = Integer.parseInt(br.readLine());
		int mod = 100999;
		
		int[] dp = new int[N + 1];
		dp[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = N; j >= i; j--) {
				dp[j] += dp[j - i];
				dp[j] %= mod;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			
			sb.append(dp[num]).append("\n");
		}
		
		System.out.println(sb);
	}
}
