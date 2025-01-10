import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Node>[] list;
	static long lcm;
	static boolean[] visited;
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		list = new ArrayList[N];
		visited = new boolean[N];
		dp = new long[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		lcm = 1;
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, p, q));
			list[b].add(new Node(a, q, p));
			lcm *= (p * q / gcd(p, q));
		}
		
		dp[0] = lcm;
		dfs(0);
		
		long mgcd = dp[0];
		for(int i = 1; i < N; i++) {
			mgcd = gcd(mgcd, dp[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(dp[i] / mgcd).append(" ");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int now) {
		visited[now] = true;
		for(Node node : list[now]) {
			int next = node.num;
			if(!visited[next]) {
				dp[next] = dp[now] * node.q / node.p;
				dfs(next);
			}
		}
	}

	private static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		else return gcd(b, a % b);
	}

	static class Node {
		int num;
		int p;
		int q;
		
		Node(int num, int p, int q) {
			this.num = num;
			this.p = p;
			this.q = q;
		}
	}
}
