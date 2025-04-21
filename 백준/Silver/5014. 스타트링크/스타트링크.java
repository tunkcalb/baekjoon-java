import java.io.*;
import java.util.*;

public class Main {
	
	static int F, S, G, U, D;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F + 1];
		
		int ans = bfs();
		
		if(ans == INF) {
			System.out.println("use the stairs");
		}else {
			System.out.println(ans);
		}
	}

	private static int bfs() {
		
		int[] ds = new int[2];
		ds[0] = U;
		ds[1] = -D;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(S, 0));
		visited[S] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			int stair = now.stair;
			int cnt = now.cnt;
			
			if(stair == G) {
				return cnt;
			}
			for(int i = 0; i < 2; i++) {
				int nextStair = stair + ds[i];
				if(nextStair <= 0 || nextStair > F) continue;
				if(visited[nextStair]) continue;
				visited[nextStair] = true;
				q.add(new Point(nextStair, cnt + 1));
			}
			
		}
		return INF;
	}
	
	static class Point {
		int stair;
		int cnt;
		
		Point(int stair, int cnt) {
			this.stair = stair;
			this.cnt = cnt;
		}
	}
}
