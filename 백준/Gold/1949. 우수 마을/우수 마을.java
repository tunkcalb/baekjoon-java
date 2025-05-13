import java.io.*;
import java.util.*;

public class Main {
	
	static int[] towns;
	static List<Integer>[] list;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		towns = new int[N + 1];
		dp = new int[N + 1][2];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			towns[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		System.out.println(Math.max(solve(1, -1, 1) + towns[1], solve(1, -1, 0)));
	}

	private static int solve(int now, int prev, int flag) {
		
		if(dp[now][flag] != -1) return dp[now][flag];
		dp[now][flag] = 0;
		
		for(int next : list[now]) {
			if(next != prev) {
				if(flag == 1) {
					dp[now][flag] += solve(next, now, 0);
				} else {
					dp[now][flag] += Math.max(solve(next, now, 1) + towns[next], solve(next, now, 0));
				}
			}
		}
		return dp[now][flag];
	}
}
