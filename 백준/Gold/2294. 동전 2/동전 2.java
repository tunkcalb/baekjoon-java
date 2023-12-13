import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		int[] dp = new int[1000000 + 1];
		
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(in.readLine());
			dp[coins[i]] = 1;
		}
		
		for(int i = 1; i <= k; i++) {
			if(dp[i] == 0) continue;
			for(int coin : coins) {
				if(i + coin <= k) {
					if(dp[i + coin] == 0) {
						dp[i + coin] = dp[i] + 1;
					}
					else {
						dp[i + coin] = Math.min(dp[i] + 1, dp[i + coin]);
					}
				}
			}
		}
		if(dp[k] != 0) {
			System.out.println(dp[k]);			
		}
		else System.out.println(-1);
	}
}
