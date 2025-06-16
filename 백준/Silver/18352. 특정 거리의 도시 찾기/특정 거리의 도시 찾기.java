import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, X;
	static int INF = 987654321;
	static  List<Integer>[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		edges = new List[N + 1];
		
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edges[a].add(b);
		}
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(X);
		dist[X] = 0;
		
	
		List<Integer> list = new ArrayList<>();
		while(!q.isEmpty()) {
			int now = q.poll();
			if(dist[now] > K) break;
			if(dist[now] == K) list.add(now);
			
			for(int next : edges[now]) {
				if(dist[next] != INF) continue;
				dist[next] = dist[now] + 1;
				q.add(next);
				
			}
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int num : list) {
			sb.append(num).append("\n");
		}
		
		System.out.println(list.isEmpty() ? -1 : sb);
		
	}
}
