import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, k;
	static int[] parent;
	static int[] cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cost = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			union(v, w);
		}
		
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			int a = find(i);
			if(set.contains(a)) continue;
			set.add(a);
			sum += cost[a];
		}
		if(sum <= k) {
			System.out.println(sum);			
		}
		else {
			System.out.println("Oh no");
		}
	}
	
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		cost[a] = Math.min(cost[a], cost[b]);
		parent[b] = a;
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
	}
}
