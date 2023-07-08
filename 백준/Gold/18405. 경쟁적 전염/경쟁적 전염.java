import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Virus {
		int num;
		int r;
		int c;

		public Virus(int num, int r, int c) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
		}
	}

	static int N, K;
	static int S, X, Y;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static List<Virus> virus;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0) {
					virus.add(new Virus(board[i][j], i, j));
				}
			}
		}
		Collections.sort(virus, (o1, o2) -> o1.num - o2.num);
		
		st = new StringTokenizer(in.readLine());
		
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		bfs();
		
		System.out.println(board[X - 1][Y - 1]);
	}

	private static void bfs() {
		
		Queue<Virus> q = new LinkedList<>();
		for(int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		for(int s = 0; s < S; s++) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				Virus now = q.poll();
				
				int num = now.num;
				int r = now.r;
				int c = now.c;
				
				for(int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != 0) continue;
					
					board[nr][nc] = num;
					q.offer(new Virus(num, nr, nc));
				}
			}
		}
		
	}
}
