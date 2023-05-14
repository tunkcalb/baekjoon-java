import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Hero{
		int r;
		int c;
		boolean sword;
		int time;
		
		public Hero(int r, int c, boolean sword, int time) {
			super();
			this.r = r;
			this.c = c;
			this.sword = sword;
			this.time = time;
		}
	}
	
	static int N, M, T;
	static int ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][][] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = T + 1;
		go();
		
		if(ans <= T) System.out.println(ans);
		else System.out.println("Fail");
	}


	private static void go() {
		Queue<Hero> q = new ArrayDeque<>();
		
		q.offer(new Hero(0, 0, false, 0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			
			Hero now = q.poll();
			
			int r = now.r;
			int c = now.c;
			boolean sword = now.sword;
			int time = now.time;
			
			if(r == N - 1 && c == M - 1) {
				ans = time;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc  >= M) continue;
				
				if(sword) {
					if(visited[nr][nc][1]) continue;
				}else {
					if(visited[nr][nc][0]) continue;
				}
				
				if(board[nr][nc] == 2) {
					visited[nr][nc][1] = true;
					q.offer(new Hero(nr, nc, true, time + 1));
					continue;
				}
				
				if(sword) {
					visited[nr][nc][1] = true;
					q.offer(new Hero(nr, nc, true, time + 1));
				}else {
					if(board[nr][nc] == 1) continue;
					visited[nr][nc][0] = true;
					q.offer(new Hero(nr, nc, false, time + 1));
				}
				
			}	
		}
	}
}
