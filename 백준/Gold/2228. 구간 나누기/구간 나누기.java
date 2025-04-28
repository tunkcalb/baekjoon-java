import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] sum;
	static int[][] dp;
	static boolean[][] visited;
	static int INIT = -32768 * 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
		}
		
		dp = new int[N + 1][N + 1];
		
		visited = new boolean[N + 1][M + 1];
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], INIT);
		}
		
		System.out.println(solve(N, M));
	}

	private static int solve(int idx, int section) {
		if(section == 0) return 0;
		if(idx < 0) return INIT;
		
		if(visited[idx][section]) return dp[idx][section];
		
		visited[idx][section] = true;
		dp[idx][section] = solve(idx - 1, section);
		for(int i = idx; i > 0; i--) {
			dp[idx][section] = Math.max(dp[idx][section], solve(i - 2, section - 1) + (sum[idx] - sum[i - 1]));
		}
		return dp[idx][section];
	}
}
