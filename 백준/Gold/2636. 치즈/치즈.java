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
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, M;
	static int cheezeCnt;
	static int prevcheeze;
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static List<Point> list;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		cheezeCnt = 0;
		list = new ArrayList<Point>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					cheezeCnt++;
					list.add(new Point(i,j));
					
				}
			}
		}
		
		melt(0);
		
	}

	private static void melt(int time) {
	
		while(cheezeCnt != 0) {
			prevcheeze = cheezeCnt;
			
			time++;
			air();
			for (int i = 0; i < list.size(); i++){
				Point now = list.get(i);
				
				int nowr = now.r;
				int nowc = now.c;
				int cnt = 0;
				for(int j = 0; j < 4; j++) {
					int nr = nowr + dr[j];
					int nc = nowc + dc[j];
					if(board[nr][nc] == 2) {
						cnt++;
					}
					
				}
				
				if(cnt >= 1) {
					board[nowr][nowc] = 0;
					cheezeCnt--;
					list.remove(now);
					i--;
				}
				
			}
			
		}
		
		System.out.println(time);
		System.out.println(prevcheeze);
		
		
	}
	
	private static void air() {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[N][M];
		
		visited[0][0] = true;
		board[0][0] = 2;
		q.offer(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(!visited[nr][nc] && board[nr][nc] != 1) {
						visited[nr][nc] = true;
						board[nr][nc] = 2; 
						q.offer(new Point(nr,nc));
					}
				}
			}
		}
	}
}