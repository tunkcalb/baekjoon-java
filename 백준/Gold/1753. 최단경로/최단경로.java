import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E;
	static int k;
	static List<Node>[] list;
	static int[] dist;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new List[V + 1];
		visited = new boolean[V + 1];
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		k = Integer.parseInt(in.readLine());

		dist[k] = 0;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v,w));
		}
		solve();
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
		
	}
	
	public static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(k,0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.end]) {
                continue;
            }
            visited[node.end] = true;
            for(Node now : list[node.end]) {
                    if(dist[now.end] > dist[node.end]+now.w) {
                    dist[now.end] = dist[node.end]+now.w;
                    pq.add(new Node(now.end,dist[now.end]));
                }   
            }
        }
    }
}

class Node implements Comparable<Node>{
	int end;
	int w;
	
	Node(int end, int w) {
		this.end = end;
		this.w = w;
	}
	
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}
