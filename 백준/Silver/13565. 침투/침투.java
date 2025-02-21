import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		
		visited = new boolean[N][M];
		for(int j = 0; j < M; j++) {
			if(!visited[0][j] && board[0][j] == 0) dfs(0, j);
		}
		System.out.println("NO");
	}

	private static void dfs(int r, int c) {
		 visited[r][c] = true;
		 
		 if(r == N - 1) {
			 System.out.println("YES");
			 System.exit(0);
		 }
		 
		 for(int i = 0; i < 4; i++) {
			 int nr = r + dr[i];
			 int nc = c + dc[i];
			 
			 if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			 if(visited[nr][nc] || board[nr][nc] == 1) continue;
			 visited[nr][nc] = true;
			 dfs(nr, nc);
		 }
	}
}
