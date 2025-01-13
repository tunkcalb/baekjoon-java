import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, H;
	static int ans;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y] = 1;
			board[x][y + 1] = 2;
		}
		
		for(int i = 0; i <= 3; i++) {
			ans = i;
			if(dfs(1, 0)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

	private static boolean dfs(int x, int cnt) {
		if(ans == cnt) {
			if(check()) return true;
			return false;
		}
		
		for(int i = x; i < H + 1; i++) {
			for(int j = 1; j < N; j++) {
				if(board[i][j] == 0 && board[i][j + 1] == 0) {
					board[i][j] = 1;
					board[i][j + 1] = 2;
					
					if(dfs(i, cnt + 1)) return true;
					board[i][j] = 0;
					board[i][j + 1] = 0;
				}
			}
		}
		return false;
	}

	private static boolean check() {
		for(int i = 1; i <= N; i++) {
			int x = 1;
			int y = i;
			
			for(int j = 0; j < H; j++) {
				if(board[x][y] == 1) y++;
				else if(board[x][y] == 2) y--;
				x++;
			}
			if(y != i) return false;
		}
		return true;
	}
}
