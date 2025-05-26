import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		int r = 0;
		int c = 0;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				char now = line.charAt(j);
				
				if(now == 'O') board[i][j] = 0;
				else if(now == 'P') board[i][j] = 1;
				else if(now == 'X') board[i][j] = -1;
				else {
					r = i;
					c = j;
				}
			}
		}
		
		int cnt = bfs(r, c);
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);
	}

	private static int bfs(int row, int col) {
		
		boolean[][] visited = new boolean[N][M];
		visited[row][col] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc] || board[nr][nc] == -1) continue;
				if(board[nr][nc] == 1) cnt++;
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));
				
			}
		}
		return cnt;
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
