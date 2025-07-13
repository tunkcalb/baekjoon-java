import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Edge> list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(from, to, cost));
		}
		Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);
		
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		int sum = 0;
		for(Edge now : list) {
			int from = now.from;
			int to = now.to;
			int cost = now.cost;
			if(from == to) continue;
			if(find(from) != find(to)) {
				union(from, to);
				sum += cost;
			}
		}
		System.out.println(sum);
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		parents[b] = a;
	}

	static class Edge {
		int from;
		int to;
		int cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
