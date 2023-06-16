import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int max = 0;
	static int count;
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
			list.get(b).add(a);
		}
		
		int[] cnt = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			count = 0;
			bfs(i);
			cnt[i] = count;
			max = Math.max(count, max);
		}
		for(int i = 1; i <= N; i++) {
			if(cnt[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}

	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(num);
		visited[num] = true;
		while(!q.isEmpty()) {
			int child = q.poll();
			for(int parent : list.get(child)) {
				if(!visited[parent]) {
					q.add(parent);
					visited[parent] = true;
					count++;
				}
			}
		}
		
	}
}
