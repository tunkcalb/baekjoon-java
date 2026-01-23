import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static List<Integer>[] board;
	static boolean[] visited;
	static int max;
	static int cnt;
	static int target;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new List[N + 1];
		visited = new boolean[N + 1];
		for(int i = 0; i <= N; i++) {
			board[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			board[start].add(end);
			board[end].add(start);
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(target).append(" ").append(max).append(" ").append(cnt);
		
		System.out.println(sb);
	}

	private static void bfs() {
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(1, 0));
		visited[1] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int node = now.node;
			int depth = now.depth;
			
			if(depth > max) {
				max = depth;
				cnt = 1;
				target = node;
			}
			else if(depth == max) {
				cnt++;
				target = Math.min(target, node);
			}
			for(int next : board[node]) {
				if(visited[next]) continue;
				
				q.offer(new Point(next, depth + 1));
				visited[next] = true; 
			}
		}
		
	}
	
	static class Point {
		int node;
		int depth;
		
		Point(int node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
