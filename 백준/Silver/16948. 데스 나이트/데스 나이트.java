import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int r1, c1, r2, c2;
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	static int[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = 6;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		
		boolean[][] visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r1, c1, 0));
		visited[r1][c1] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			
			if(r == r2 && c == c2) {
				return cnt;
			}
			for(int i = 0; i < M; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc, cnt + 1));
			}
		}
		return -1;
	}
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
