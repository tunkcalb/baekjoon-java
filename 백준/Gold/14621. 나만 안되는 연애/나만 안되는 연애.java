import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int w;
		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	static int N, M;
	static int ans, cnt;
	static char[] school;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] list = new ArrayList[N + 1];
		
		school = new char[N + 1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			school[i] = st.nextToken().charAt(0);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(school[from] == school[to]) continue;
			
			list[from].add(new Node(to,w));
			list[to].add(new Node(from,w));
		}
		
		ans = 0;
		cnt = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		
		pq.offer(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true; 
			ans += now.w;
			cnt++;
			
			for(Node node : list[now.to]) {
				if(visited[node.to]) continue;
				pq.offer(node);
			}
		}
		
		if(cnt != N) ans = -1;
		System.out.println(ans);
	}	
}
