import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int empty;
	static int ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Virus[] active;	
	static List<Virus> viruses;	
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		viruses = new ArrayList<>();
		active = new Virus[M];
		empty = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) empty++;
				else if(board[i][j] == 2) viruses.add(new Virus(i, j, 0));
			}
		}
		
		ans = Integer.MAX_VALUE;
		if(empty == 0) System.out.println(0);
		else {
			select(0, 0);
			System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}
		
	}
	
	private static void select(int start, int cnt) {
		if(cnt == M) {
			spread(empty);
			return;
		}
		
		for(int i = start; i < viruses.size(); i++) {
			active[cnt] = viruses.get(i);
			select(i + 1, cnt + 1);
		}
	}

	private static void spread(int cnt) {
		Queue<Virus> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			Virus virus = active[i];
			visited[virus.r][virus.c] = true;
			q.add(virus);
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = virus.r + dr[i];
				int nc = virus.c + dc[i];
				int t = virus.t;
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc] || board[nr][nc] == 1) continue;
				if(board[nr][nc] == 0) cnt--;
				if(cnt == 0) {
					ans = Math.min(ans , virus.t + 1);
					return;
				}
				visited[nr][nc] = true;
				q.add(new Virus(nr, nc, t + 1));
			}
		}
	}

	static class Virus {
		int r, c, t;
		
		Virus(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
}
