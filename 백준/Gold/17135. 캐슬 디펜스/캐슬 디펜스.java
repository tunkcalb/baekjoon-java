import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, D;
	static int max;
	static int cnt;
	static Point[] archers;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] board;
	static int[][] original;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		archers = new Point[3];
		board = new int[N + 1][M];
		original = new int[N + 1][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		combination(0, 0);
		System.out.println(max);
	}
	
	
	private static void combination(int idx, int cnt) {
		
		if(cnt == 3) {
			start();
			return;
		}
		
		for(int i = idx; i < M; i++) {
			archers[cnt] = new Point(N, i);
			combination(i + 1, cnt + 1);
		}
		
	}


	private static void start() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				board[i][j] = original[i][j];
			}
		}
		cnt = 0;
		for(int i = 0; i < N; i++) {
			shot();
			move();			
		}
		max = Math.max(max, cnt);
	}


	private static void move() {
		for(int i = N - 1; i > 0; i--) {
			for(int j = 0; j < M; j++) {
				board[i][j] = board[i - 1][j];
				board[i - 1][j] = 0;
			}
		}
	}


	private static void shot() {
		List<Point> shots = new ArrayList<>();
		for(int t = 0; t < 3; t++) {
			boolean[][] visited = new boolean[N][M];
			Point archer = archers[t];
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(archer.r, archer.c, 0));
			List<Point> list = new ArrayList<>();
			while(!q.isEmpty()) {
				int size = q.size();
				for(int j = 0; j < size; j++) {
					Point now = q.poll();
					int r = now.r;
					int c = now.c;
					int cnt = now.cnt;
					if(board[r][c] == 1) {
						list.add(new Point(r, c));
						continue;
					}
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || cnt == D) continue;
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, cnt + 1));
					}
				}
				if(list.isEmpty()) continue;
				Collections.sort(list, (o1, o2) -> o1.c - o2.c);
				shots.add(list.get(0));
				break;
			}
		}
		for(Point shot : shots) {
			int r = shot.r;
			int c = shot.c;
			if(board[r][c] == 1) {
				board[r][c] = 0;
				cnt++;
			}
		}
	}


	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
