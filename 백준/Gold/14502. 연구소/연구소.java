import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	
	}
	
	static int N, M;
	static int cnt;
	static int wall;
	static int ans;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] isWall;
	static boolean[][] visited;
	static int[][] board;
	static List<Point> virus;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		isWall = new boolean[N][M];
		board = new int[N][M];
		virus = new ArrayList<>();
		cnt = 0;
		wall = 3;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) {
					cnt++;
				}else {
					isWall[i][j] = true;
				}
				if(board[i][j] == 2) virus.add(new Point(i,j));
			}
		}
		
		ans = 0;
		combination(0);
		System.out.println(ans);
		
	}

	private static void combination(int count) {
		if(count == wall) {
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(isWall[i][j]) continue;
				isWall[i][j] = true;
				board[i][j] = 1;
				combination(count + 1);
				isWall[i][j] = false;
				board[i][j] = 0;
				
			}
		}
		
	}

	private static void bfs() {
		
		visited = new boolean[N][M];
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = board[i][j];
			}
		}
		
		Queue<Point> q = new ArrayDeque<>();
		for(int i = 0; i < virus.size(); i++) {
			int r = virus.get(i).r;
			int c = virus.get(i).c;
			
			visited[r][c] = true;
			q.offer(new Point(r,c));
		}
		
		int count = cnt;
		count -= 3;
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && copy[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					copy[nr][nc] = 2;
					q.offer(new Point(nr,nc));	
					count--;
					
				}	
			}
		}
		
		
		
		if(ans < count) ans = count;
		
	}
}