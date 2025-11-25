import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static List<List<Integer>> list;
	static int[] idxs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		idxs = new int[N + 1];
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(idxs[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(R);
		int idx = 1;
		while(!q.isEmpty()) {
			
			int now = q.poll();
			
			if(idxs[now] != 0) continue;
			
			idxs[now] = idx++;
			
			for(int next : list.get(now)) {
				if(idxs[next] != 0) continue;
				
				q.offer(next);
			}
			
		}
	}
}
