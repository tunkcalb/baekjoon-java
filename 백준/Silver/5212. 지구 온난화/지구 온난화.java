import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				char now = line.charAt(j);
				board[i][j] = now;
			}
		}
		
		char[][] after = new char[R][C];
		
		int rMax = 0;
		int cMax = 0;
		int rMin = R;
		int cMin = C;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board [i][j] == 'X' && check(i, j) < 3) {
					after[i][j] = 'X';
					rMax = Math.max(rMax, i);
					cMax = Math.max(cMax, j);
					rMin = Math.min(rMin, i);
					cMin = Math.min(cMin, j);
				}
				else after[i][j] = '.';
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = rMin; i <= rMax; i++) {
			for(int j = cMin; j <= cMax; j++) {
				sb.append(after[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static int check(int r, int c) {
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == '.') cnt++;
		}
		return cnt;
	}
}
