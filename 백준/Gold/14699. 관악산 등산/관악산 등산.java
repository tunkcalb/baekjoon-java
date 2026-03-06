import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static List<List<Integer>> list;
	static int[] height;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		height = new int[N + 1];
		dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}

		for(int i = 1; i <= N; i++) {
			System.out.println(dfs(i));
		}
	}

	private static int dfs(int now) {
		if(dp[now] != 0) return dp[now];
		
		dp[now] = 1;
		
		for(int next : list.get(now)) {
			if(height[next]> height[now]) {
				dp[now] = Math.max(dp[now], dfs(next) + 1);
			}
		}
		
		return dp[now];
	}
}
