import java.io.*;
import java.util.*;

public class Main {
	
	static int[] limit;
	static Set<Integer> set;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = 3;
		limit = new int[N];
		visited = new boolean[201][201];
		for(int i = 0; i < N; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		set = new TreeSet<>();
		dfs(0, 0, limit[N - 1]);
		
		for(int num : set) {
			System.out.print(num + " ");
		}
	}
	private static void dfs(int a, int b, int c) {
		if(visited[a][b]) return;
		
		if(a == 0) {
			set.add(c);
		}
		visited[a][b] = true;
		
		if(a + b > limit[1]) {
			dfs((a + b) - limit[1], limit[1], c);
		} else {
			dfs(0, a + b, c);
		}
		
		if(a + b > limit[0]) {
			dfs(limit[0], a + b - limit[0], c);
		} else {
			dfs(a + b, 0, c);
		}
		
		if(a + c > limit[0]) {
			dfs(limit[0], b, a + c - limit[0]);
		} else {
			dfs(a + c, b, 0);
		}
		
		if(b + c > limit[1]) {
			dfs(a, limit[1], b + c - limit[1]);
		} else {
			dfs(a, b + c, 0);
		}
		
		dfs(a, 0, b + c);
		dfs(0, b, a + c);
	}
}
