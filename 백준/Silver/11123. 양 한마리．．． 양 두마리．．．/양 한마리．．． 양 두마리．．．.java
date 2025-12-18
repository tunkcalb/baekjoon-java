import java.io.*;
import java.util.*;

public class Main {
	
	static int H, W;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			board = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				String line = br.readLine();
				for(int j = 0; j < W; j++) {
					if(line.charAt(j) == '#') {
						board[i][j] = 1;
					}
				}
			}
			
			visited = new boolean[H][W];
			int cnt = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(board[i][j] == 1 && !visited[i][j]) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int row, int col) {
		visited[row][col] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				if(visited[nr][nc] || board[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
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
