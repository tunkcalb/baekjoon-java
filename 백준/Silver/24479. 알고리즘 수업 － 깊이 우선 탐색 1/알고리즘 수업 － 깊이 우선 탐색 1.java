import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int cnt;
	static int[] ans;
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new List[N + 1];
		visited = new boolean[N + 1];
		ans = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		cnt = 1;
		visited[R] = true;
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static void dfs(int now) {
		
		ans[now] = cnt++;
		
		for(int next : list[now]) {
			if(visited[next]) continue;
			
			visited[next] = true;
			dfs(next);
		}
	}
}
