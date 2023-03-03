import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int t;
		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
		@Override
		public int compareTo(Point o) {
			if(o.t == this.t) {
				if(o.r == this.r) return this.c - o.c;
				else return this.r - o.r;
			}
			return this.t - o.t;
		}
	}
	
	private static StringBuilder sb = new StringBuilder();
	private static int N, r, c;
	private static int size;
	private static int time;
	private static int sizeCnt;
	private static int sharkCnt;
	
	private static int[][] board;
	private static boolean[][] visited;
	private static int[] dr = {-1, 0, 0, 1};
	private static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		
		board = new int[N][N];
		time = 0;
		size = 2;
		sizeCnt = 0;
		sharkCnt = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 9) {
					r = i;
					c = j;
				}else if(board[i][j] != 0) {
					sharkCnt++;
				}
			}
		}
		board[r][c] = 0;
		int num = sharkCnt;
		for(int i = 0; i < num; i++) {
			if(sharkCnt == 0) break;
			Point fish = bfs();
			if(fish == null) break;
			board[fish.r][fish.c] = 0;
			r = fish.r;
			c = fish.c;
			sharkCnt--;
			sizeCnt++;
			time += fish.t;
			if(sizeCnt == size) {
				size++;
				sizeCnt = 0;
			}
		}
		
		System.out.println(time);
		
		
		
		
		
	}

	private static Point bfs() {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		visited[r][c] = true;
		List<Point> feed = new ArrayList<>();
		q.offer(new Point(r,c,0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i = 0; i < dr.length; i++) {
				int nr = now.r;
				int nc = now.c;
				int t = now.t;
				nr += dr[i];
				nc += dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(board[nr][nc] <= size && !visited[nr][nc]) {
					if(board[nr][nc] != 0 && board[nr][nc] != size) {
						q.offer(new Point(nr,nc, t + 1));
						visited[nr][nc] = true;
						feed.add(new Point(nr,nc, t + 1));
					}
					else {
						visited[nr][nc] = true;
						q.offer(new Point(nr,nc, t + 1));
					}
				}
				
			}
		}
		
		if(!feed.isEmpty()) return (eatable(feed));
		
		return null;
	}

	private static Point eatable(List<Point> feed) {
		
		Collections.sort(feed);
		Point fish = feed.get(0);
		board[fish.r][fish.c] = 0;
		return fish;
	}
	
}