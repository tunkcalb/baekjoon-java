import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] male = new int[n + 1];
		int[] female = new int[m + 1];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= n; i++) {
			male[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= m; i++) {
			female[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(male);
		Arrays.sort(female);
		int[][] dp = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j - 1] + Math.abs(male[i] - female[j]);
				if(i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
				else if(i > j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
			}
			
		}
		System.out.println(dp[n][m]);
	}
}
