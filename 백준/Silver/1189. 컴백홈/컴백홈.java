import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, K;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i = 0; i < R; i++) {
			String line = in.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		visited[R - 1][0] = true;
		
		cnt = 0;
		dfs(R - 1, 0, 1);
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int distance) {
		if(r == 0 && c == C - 1) {
			if(distance == K) cnt++;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if(visited[nr][nc] || board[nr][nc] == 'T') continue;
			visited[nr][nc] = true;
			dfs(nr, nc, distance + 1);
			visited[nr][nc] = false;
		}
	}
}
