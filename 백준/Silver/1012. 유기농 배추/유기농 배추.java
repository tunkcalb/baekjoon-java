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

	static int T;
	static int M, N, K;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st = new StringTokenizer(in.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			board = new int[M][N];
			visited = new boolean[M][N];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(in.readLine());

				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				board[r][c] = 1;

			}

			cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int i, int j) {

		
		Queue<Point> q = new ArrayDeque<>();
		visited[i][j] = true;
		board[i][j] = 0;
		
		q.offer(new Point(i, j));
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && board[nr][nc] == 1) {
					visited[nr][nc] = true;
					board[nr][nc] = 0;
					q.offer(new Point(nr, nc));
				}
				
				
			}
			
		}
		
	}
}