import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int cnt;
	static int[] dp = new int[13];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dfs(0, 0);
		System.out.println(-1);
		
	}

	private static void dfs(int sum, int level) {
		
		if(sum > n) return;
		if(sum == n) {
			cnt++;
			if(cnt == k) {
				for(int i = 0; i < level - 1; i++) {
					System.out.print(dp[i] + "+");
				}
				System.out.println(dp[level - 1]);
				System.exit(0);
			}			
		}
		for(int i = 1; i <= 3; i++) {
			dp[level] = i;
			dfs(sum + i, level + 1);
		}
	}
}
