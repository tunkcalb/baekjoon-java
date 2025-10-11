import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[c + 100 + 1];
		
		int INF = 98764321;
		
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = cnt; j < c + 100 + 1; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j - cnt]);
			}
		}
		
		int ans = INF;
		
		for(int i = c; i < c + 100 + 1; i++) {
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
