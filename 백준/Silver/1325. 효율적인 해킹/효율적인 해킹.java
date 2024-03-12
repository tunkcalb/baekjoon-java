import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int max;
	static int[] cnt;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}
		
		cnt = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}

		for(int i = 1; i <= N; i++) {
			max = Math.max(cnt[i], max);
		}
		
		for(int i = 1; i <= N; i++) {
			if(cnt[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int parent) {
		visited[parent] = true;
		for(int child : list.get(parent)) {
			if(visited[child]) continue;
			cnt[child]++;
			dfs(child);
		}
	}	
}
