import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, X;
	static int cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		List<Integer>[] child;
		List<Integer>[] parent;
		
		parent = new ArrayList[N + 1];
		child = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			parent[U].add(V);
			child[V].add(U);
		}
		
		cnt = 0;
		visited = new boolean[N + 1];
		visited[X] = true;
		check(X, child);
		sb.append(1 + cnt).append(" ");
		
		cnt = 0;
		visited = new boolean[N + 1];
		visited[X] = true;
		check(X, parent);
		
		sb.append(N - cnt);
		
		System.out.println(sb);		
	} 

	private static void check(int now,List<Integer>[] list) {
		
		for(int next : list[now]) {
			if(!visited[next]) {
				visited[next] = true;
				cnt++;
				check(next, list);
			}
		}
		
	}
}
