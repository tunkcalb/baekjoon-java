import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		if(K > C * R) {
			System.out.println(0);
		}
		else {
			int r = 0;
			int c = 0;
			int dir = 0;
			
			int[][] board = new int[R][C];
			for(int i = 1; i <= R * C; i++) {
				board[r][c] = i;
				if(i == K) {
					System.out.println((c + 1) + " " + (r + 1));
					break;
				}
				
				while(true) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] != 0) dir = (dir + 1) % 4;
					else {
						r = nr;
						c = nc;
						break;
					}
				}
				
			}
		}
	}
}
