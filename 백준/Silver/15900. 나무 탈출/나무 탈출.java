import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<List<Integer>> line;
	static int ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		line =  new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			line.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			line.get(a).add(b);
			line.get(b).add(a);
		}
		
		
		ans = 0;
		visited = new boolean[N + 1];
		dfs(1, 0);
		
		if(ans % 2 == 0) {
			System.out.println("No");
		}
		else System.out.println("Yes");
	}

	private static void dfs(int now, int cnt) {
		visited[now] = true;
		
		for(int next : line.get(now)) {
			if(!visited[next]) dfs(next, cnt + 1);
		}
		
		if(now != 1 && line.get(now).size() == 1) {
			ans += cnt;
		}
	}
}
