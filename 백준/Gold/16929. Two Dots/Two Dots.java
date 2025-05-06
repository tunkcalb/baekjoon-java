import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int row, col;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j <= M; j++) {
				board[i][j] = line.charAt(j - 1) - 'A';
			}
		}
		
		visited = new boolean[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				row = i;
				col = j;
				if(dfs(i, j, 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

	private static boolean dfs(int r, int c, int cnt) {
		if(cnt >= 4 && r == row && c == col) return true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <= 0 || nr > N || nc <= 0 || nc > M) continue;
			if(board[nr][nc] != board[r][c]) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(dfs(nr, nc, cnt + 1)) return true;
			visited[nr][nc] = false;
		}
		
		visited[r][c] = false;
		return false;
	}
}
