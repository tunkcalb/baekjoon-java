import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	static int N, M;
	static int cnt;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] board;
	static int[][] sum;
	static int[][] number;
	static boolean[][] visited;
	static List<Point> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
				if(board[i][j] == 1) {
					list.add(new Point(i, j));
				}
				
			}
		}
		visited = new boolean[N][M];
		sum = new int[N][M];
		number = new int[N][M];
		int time = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 0 && !visited[i][j]) {
					cnt = 0;
					bfs(i, j, time++);
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			Point now = list.get(i);
			int r = now.r;
			int c = now.c;
			board[r][c] = 1;
			HashSet<Integer> set = new HashSet<>();
			for(int j = 0; j < 4; j++) {
				int nr = now.r + dr[j];
				int nc = now.c + dc[j];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(!set.contains(number[nr][nc])) {
					set.add(number[nr][nc]);
					board[r][c] += sum[nr][nc];					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(board[i][j] % 10);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int row, int col, int num) {
		List<Point> count = new ArrayList<>();
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(row, col));
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			count.add(now);
			cnt++;
			
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != 0 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));
				
			}
		}

		for(int i = 0; i < count.size(); i++) {
			Point now = count.get(i);
			number[now.r][now.c] = num;
			sum[now.r][now.c]= count.size(); 
		}
		
	}
}
