import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static HashSet<String> set;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = 5;
		
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dfs(i, j, "" + board[i][j]);
			}
		}
		System.out.println(set.size());
	}


	private static void dfs(int r, int c, String word ) {
		if(word.length() == N + 1) {
			set.add(word);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			dfs(nr, nc, word + board[nr][nc]);
		}
	}
}
