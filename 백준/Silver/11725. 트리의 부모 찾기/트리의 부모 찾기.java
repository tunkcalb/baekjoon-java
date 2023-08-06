import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent; 
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		parent = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i = 0; i < N; i++) {
			
		}
		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}

	}

	private static void dfs(int num) {
		visited[num] = true;
		for(int i : list[num]) {
			if(!visited[i]) {
				parent[i] = num;
				dfs(i);
			}
		}
	}
}
