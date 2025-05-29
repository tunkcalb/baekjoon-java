import java.io.*;
import java.util.*;

public class Main {
	
	static int INF = 987654321;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		List<Node>[] list = new List[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
		}
		
		boolean[] visited = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		dist[A] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(A, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.to;
			int cost = node.cost;
			
			if(dist[now] < cost) continue;
			
			for(Node next : list[now]) {
				if(dist[next.to] > dist[now] + next.cost) {
					dist[next.to] = dist[now] + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
			
		}
		
		System.out.println(dist[B]);
		
	}
	
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
