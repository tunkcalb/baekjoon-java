import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] nums  = {1, 7, 4, 2, 0, 8};
		long[] dp = new long[100 + 1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		for(int i = 9; i <= 100; i++) {
			for(int j = 2; j <= 7; j++) {
				String tmp = String.valueOf(dp[i - j]) + String.valueOf(nums[j - 2]);
				dp[i] = Math.min(dp[i], Long.parseLong(tmp));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append(" ");
			String maxNum = makeMaxNum(n);
			sb.append(maxNum).append("\n");
		}
		System.out.println(sb);
	}

	private static String makeMaxNum(int n) {
		StringBuilder sb = new StringBuilder();
		if(n % 2 == 0) {
			for(int i = 0; i < n / 2; i++) {
				sb.append("1");
			}
		}
		else {
			sb.append("7");
			for(int i = 0; i < (n - 3) / 2; i++) {
				sb.append("1");
			}
		}
		return sb.toString();
	}
}
