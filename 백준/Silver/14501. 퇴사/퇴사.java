import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N + 1][2];
		int[] dp = new int[N + 1 + 5];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			cost[i][0] = t;
			cost[i][1] = p;
		}
		
		for(int i = 1; i <= N; i++) {
			int t = cost[i][0];
			int p = cost[i][1];
			
			dp[i + t] = Math.max(dp[i + t], dp[i] + p);
			for(int j = i + t + 1; j <= N; j++) {
				dp[j] = Math.max(dp[j], dp[i + t]);
			}
		}
		
		int max = 0;
		for(int i = 1; i <= N + 1; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
