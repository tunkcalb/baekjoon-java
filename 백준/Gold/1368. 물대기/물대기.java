import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] parent;
	static List<Edge> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			int cost = Integer.parseInt(br.readLine());
			list.add(new Edge(0, i, cost));
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				list.add(new Edge(i, j, cost));
			}
		}
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(list,(o1, o2) -> o1.cost - o2.cost);
		
		int cnt = 0;
		int sum = 0;
		for(Edge edge : list) {
			int from = edge.from;
			int to = edge.to;
			int cost = edge.cost;
			
			if(union(from, to)) {
				cnt++;
				sum += cost;
				if(cnt == N) break;
			}
		}
		
		System.out.println(sum);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return false;
		parent[a] = b;
		return true;
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
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
