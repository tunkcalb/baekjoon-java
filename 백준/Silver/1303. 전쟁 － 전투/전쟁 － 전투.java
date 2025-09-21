import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				char now = line.charAt(j);
				if(now == 'W') board[i][j] = 0;
				else board[i][j] = 1;
			}
		}
		
		int w = 0;
		int b = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					int now = board[i][j];
					cnt = 0;
					visited[i][j] = true;
					dfs(i, j, now);
					if(now == 0) w += cnt * cnt;
					else b += cnt * cnt;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(w).append(" ").append(b);
		System.out.println(sb);
	}

	private static void dfs(int r, int c, int now) {
		cnt++;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
			if(visited[nr][nc] || board[nr][nc] != now) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, now);
		}
	}
	
}
