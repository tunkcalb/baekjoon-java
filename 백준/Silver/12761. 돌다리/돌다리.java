import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, N, M;
	static int size;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		size = 100000;
		visited = new boolean[size + 1];
		int min = bfs();
		
		System.out.println(min);
	}

	private static int bfs() {
		
		Queue<Point> q = new LinkedList<>();
		visited[N] = true;
		q.offer(new Point(N, 0));

		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int idx = now.idx;
			int cnt = now.cnt;
			if(idx == M) {
				return cnt;
			}
			int[] nextIdx = {idx - 1, idx + 1, idx - A, idx - B, idx + A, idx + B, idx * A, idx * B};
			
			for(int next : nextIdx) {
				if(next > size || next < 0) continue;
				if(visited[next]) continue;
				visited[next] = true;
				q.offer(new Point(next, cnt + 1));
			}
			
		}
		
		
		return -1;
	}
	
	static class Point {
		int idx;
		int cnt;

		Point(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
