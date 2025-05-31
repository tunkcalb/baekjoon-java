import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int R;
	static int cnt;
	static List<Integer>[] edge;
	static int[] cnts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		edge = new List[N + 1];
		
		for(int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edge[u].add(v);
			edge[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(edge[i], Collections.reverseOrder());
		}
				
		cnts = new int[N + 1];
		cnt = 1;
		cnts[R] = cnt++;
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			sb.append(cnts[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int now) {
		
		for(int next : edge[now]) {
			if(cnts[next] != 0) continue;
			cnts[next] = cnt++;
			dfs(next);
		}
	}
}
