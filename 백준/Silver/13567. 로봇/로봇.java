import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		board = new int[M][M];
		int r = 0;
		int c = 0;
		int dir = 0;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case "MOVE":
				int nr = r + dr[dir] * num;
				int nc = c + dc[dir] * num;
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= M) {
					System.out.println(-1);
					return;
				}
				
				r = nr;
				c = nc;
				break;
			case "TURN":
				if(num == 0) {
					dir += 3;
					dir %= 4;
				}
				else if (num == 1) {
					dir += 1;
					dir %= 4;
				}
				break;
			}
		}
		
		sb.append(c).append(" ").append(r);
		System.out.println(sb);
		
	}
}
