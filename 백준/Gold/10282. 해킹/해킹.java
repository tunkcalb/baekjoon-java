import java.io.*;
import java.util.*;

public class Main {
	
	static int n, d, c;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			List<List<Node>> graph = new ArrayList<>();
			
			for(int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				graph.get(b).add(new Node(a, s));
			}
			
			int[] dist = dijkstra(graph);
			
			int virusCount = 0;
			int totalSeconds = 0;
			
			for(int i : dist) {
				if(i != INF) {
					virusCount += 1;
					totalSeconds = Math.max(totalSeconds,  i);
				}
			}
			sb.append(virusCount).append(" ").append(totalSeconds).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int[] dijkstra(List<List<Node>> graph) {
		int[] dist = new int[n + 1];
		
		Arrays.fill(dist, INF);
		dist[c] = 0;
		
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(c, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int next = node.next;
			int second = node.second;
			
			for(Node nextNode : graph.get(next)) {
				if(dist[nextNode.next] > second + nextNode.second) {
					dist[nextNode.next] = second + nextNode.second; 
					q.add(new Node(nextNode.next, dist[nextNode.next]));
				}
			}
		}
		return dist;
	}

	static class Node implements Comparable<Node> {
		int next;
		int second;
		
		public Node(int next, int second) {
			this.next = next;
			this.second = second;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.second - o.second;
		}
	}
}
