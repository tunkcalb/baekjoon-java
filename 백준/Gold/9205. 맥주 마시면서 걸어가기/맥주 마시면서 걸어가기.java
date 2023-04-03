import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	
	static StringBuilder sb = new StringBuilder();
	static int t, N;
	static int[][] board;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(in.readLine());
			board = new int[N + 2][2];
			visited = new boolean[N + 2];
			
			for(int i = 0; i < N + 2; i++) {
				StringTokenizer st = new  StringTokenizer(in.readLine());
				board[i][0] = Integer.parseInt(st.nextToken());
				board[i][1] = Integer.parseInt(st.nextToken());
			}
			
			bfs();
		}
		
		
		
	}

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		
		visited[0] = true;
		q.offer(new Point(board[0][0], board[0][1]));
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			
			if(r == board[N + 1][0] && c == board[N + 1][1]) {
				System.out.println("happy");
				return;
			}
			
			for(int i = 1; i < N + 2; i++) {
				int nr = board[i][0];
				int nc = board[i][1];
				
				if(Math.abs(r - nr) + Math.abs(c - nc) <= 1000 && !visited[i]){
					visited[i] = true;
					q.offer(new Point(nr, nc));
				}
			}
			
		}
		System.out.println("sad");
	}
	
	
	
}
