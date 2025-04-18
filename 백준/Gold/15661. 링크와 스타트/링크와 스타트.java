import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int min;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		solve(0, 0);
		System.out.println(min);
	}

	private static void solve(int cnt, long visited) {
		if(cnt == N) {
			if(visited == 0 || visited == (1L << N) - 1) return;
			int start = 0;
			int link = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(((visited & (1L << i)) == 0) != ((visited & (1L << j)) == 0)) continue;
					if((visited & (1L << i)) == 0) {
						start += board[i][j] + board[j][i];
					}
					else {
						link += board[i][j] + board[j][i];
					}
				}
			}
			
			int abs = Math.abs(start - link);
			min = Math.min(min, abs);
			return;
		}
		
		solve(cnt + 1, visited | (1L << cnt));
		solve(cnt + 1, visited);
	}
}
