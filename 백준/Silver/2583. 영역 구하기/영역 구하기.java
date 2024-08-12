import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int K;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<Integer> list;
	
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			for(int i = r1; i < r2; i++) {
				for(int j = c1; j < c2; j++) {
					board[i][j] = true;
				}
			}
		}
		
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!board[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		
		sb.append(cnt).append("\n");
		for(int num : list) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int row, int col) {
		int sum = 1;
		board[row][col] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc]) continue;
				q.offer(new Point(nr, nc));
				board[nr][nc] = true;
				sum++;
			}
		}
		list.add(sum);
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
