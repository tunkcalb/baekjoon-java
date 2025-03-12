import java.io.*;
import java.util.*;

public class Main {
	
	static int a, b;
	static int N, M;
	static int min;
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list[c].add(d);
			list[d].add(c);
		}
		
		min = N + 1;
		bfs();
		
		System.out.println(min == N + 1 ? -1 : min);
	}

	private static void bfs() {
		visited = new boolean[N + 1];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, 0));
		visited[a] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int num = now.num;
			int cnt = now.cnt;
			
			if(num == b) {
				min = Math.min(min, cnt);
			}
			
			for(int next : list[num]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(new Point(next, cnt + 1));
			}
		}
	}
	
	static class Point {
		int num;
		int cnt;
		
		Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
