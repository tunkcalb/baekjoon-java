import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
		 
		
	}
	
	static int N;
	static int num;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] board;
	static int[][] dijk;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		num = 0;
		while(true) {
			num++;
			N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			
			board = new int[N][N];
			dijk = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}
			
			cal();
			
			
		}
		System.out.println(sb);
	}

	private static void cal() {
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		dijk[0][0] = board[0][0];
		
		pq.offer(new Point(0,0, board[0][0]));
		
		while(!pq.isEmpty()) {
			
			Point now = pq.poll();
			
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if(dijk[nr][nc] > dijk[r][c] + board[nr][nc]) {
						dijk[nr][nc] = dijk[r][c] + board[nr][nc];
						pq.offer(new Point(nr, nc, dijk[nr][nc]));
					}
				}
			}
		}
		
		sb.append("Problem " + num + ": " + dijk[N-1][N-1]).append("\n");
		
		
	}
}