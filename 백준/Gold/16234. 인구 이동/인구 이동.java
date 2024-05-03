import java.io.*;
import java.util.*;

public class Main {
	
	static int N, L, R;
	static int cnt;
	static boolean flag;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		while(true) {
			flag = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			if(!flag) break;
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		Point now = new Point(row, col);
		q.offer(now);
		visited[row][col] = true;
		List<Point> list = new ArrayList<>();
		list.add(now);
		
		while(!q.isEmpty()) {
			now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc]) continue;
				int gap = Math.abs(board[r][c] - board[nr][nc]);
				if(gap < L || gap > R) continue;
				Point next = new Point(nr, nc);
				q.offer(next);
				visited[nr][nc] = true;
				list.add(next);
			}
		}
		if(list.size() == 1) return;
		move(list);
	}

	private static void move(List<Point> list) {
		int sum = 0;
		
		for(Point land : list) {
			int r = land.r;
			int c = land.c;
			
			sum += board[r][c];
		}
		sum /= list.size();
		
		for(Point land : list) {
			int r = land.r;
			int c = land.c;
			
			board[r][c] = sum;
		}
		flag = true;
	}
	
}

class Point {
	int r;
	int c;
	
	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
