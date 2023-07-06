import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T, W;
	static int ans;
	static int[] location;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		location = new int[T + 1];
		
		for(int i = 1; i <= T; i++) {
			location[i] = Integer.parseInt(in.readLine());
		}
		
		int[][] dp = new int[T + 1][W + 1];
		for(int t = 1; t <= T; t++) {
			int treePos = location[t];
			
			for(int w = 0; w <= W; w++) {
				if(w == 0) {
					int pos = 1;
					if(treePos == pos) {
						dp[t][w] = dp[t - 1][w] + 1;
					}
					else {
						dp[t][w] = dp[t - 1][w];
					}
				}
				else if (w % 2 == 0) {
					int pos = 1;
					if(treePos == pos) {
						dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1]);
					}
					else {
						dp[t][w] = Math.max(dp[t - 1][w - 1] + 1, dp[t - 1][w]);
					}
				}
				else {
					int pos = 2;
					if(treePos == pos) {
						dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1]);
					}
					else {
						dp[t][w] = Math.max(dp[t - 1][w - 1] + 1, dp[t - 1][w]);
					}
				}
				ans = Math.max(ans, dp[t][w]);
			}
		}
		
		System.out.println(ans);
	}
}
