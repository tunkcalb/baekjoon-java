import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] list;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new List[n + 1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int a = 1; a <= n; a++) {
			int b = Integer.parseInt(st.nextToken());
			if(b == -1) continue;
			list[b].add(a);
		}
		
		dp = new int[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			dp[idx] += w;
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(dp[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int now) {
		for(int next : list[now]) {
			dp[next] += dp[now];
			dfs(next);
		}
	}
}
