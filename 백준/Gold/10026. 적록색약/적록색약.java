import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static char[][] board;
	private static char[][] board2;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static char zone;
	private static int cnt1;
	private static int cnt2;

	public static void main(String[] args) throws Exception {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		board = new char[N][N];
		board2 = new char[N][N];
		for(int i = 0; i < N; i++) {
			String Line = in.readLine();
			for(int j = 0; j < N; j++) {
				char color = Line.charAt(j);
				board[i][j] = color;
				if(color == 'G') board2[i][j] = 'R';
				else board2[i][j] = color;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] != 0) {
					zone = board[i][j];
					bfs(i, j);
					cnt1++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board2[i][j] != 0) {
					zone = board2[i][j];
					bfs2(i, j);
					cnt2++;
				}
			}
		}
		
		System.out.print(cnt1 + " " + cnt2);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		int[] now = {r, c};
		board[r][c] = 0;
		q.offer(now);
		
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i = 0; i < 4; i++) {
				int[] next = {now[0] + dr[i], now[1] + dc[i]};
				
				if(next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < N && board[next[0]][next[1]] == zone) {
					board[next[0]][next[1]] = 0;
					q.offer(next);
				}	
			}
		}
	}
	
	private static void bfs2(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		int[] now = {r, c};
		board2[r][c] = 0;
		q.offer(now);
		
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i = 0; i < 4; i++) {
				int[] next = {now[0] + dr[i], now[1] + dc[i]};
				
				if(next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < N && board2[next[0]][next[1]] == zone) {
					board2[next[0]][next[1]] = 0;
					q.offer(next);
				}	
			}
		}
	}
}