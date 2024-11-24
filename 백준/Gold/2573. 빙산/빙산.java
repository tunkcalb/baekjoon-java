import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int[][] tmp;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<Point> list;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		int day = 0;
		while(true) {
			cal(day);
			day++;
		}
		
		
	}

	private static void cal(int day) {
		int cnt = check();
		
		if(cnt == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		if(cnt > 1) {
			System.out.println(day);
			System.exit(0);
		}
		
		melt();
	}
	
	private static void melt() {
		tmp = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				tmp[r][c] = board[r][c];
				if(board[r][c] != 0) {
					for(int i = 0; i < 4; i++) {
						if(tmp[r][c] == 0) break;

						int nr = r + dr[i];
						int nc = c + dc[i];
						if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						if(board[nr][nc] == 0) tmp[r][c]--;
					}
				}
			}
		}
		board = tmp;
	}

	private static int check() {
		visited = new boolean[N][M];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));	
			}
		}
	}

	static class Point{
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
