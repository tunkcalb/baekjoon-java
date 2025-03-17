import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, X;
	static int INF = Integer.MAX_VALUE;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] adj = new ArrayList[N + 1];
        ArrayList<int[]>[] reverseAdj = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			reverseAdj[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			adj[n1].add(new int[]{n2, t});
			reverseAdj[n2].add(new int[] {n1, t});
		}
		
		int[] dist = dijkstra(adj);
		int[] reverseDist = dijkstra(reverseAdj);
		
		int ans = 0;
		
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, dist[i] + reverseDist[i]);
		}
		System.out.println(ans);
	}

	private static int[] dijkstra(ArrayList<int[]>[] adj) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		q.add(new int[] {X, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(dist[cur[0]] < cur[1]) continue;
			dist[cur[0]] = cur[1];
			for(int[] next : adj[cur[0]]) {
				q.add(new int[] {next[0], cur[1] + next[1]});
			}
		}
		return dist;
	}
}
