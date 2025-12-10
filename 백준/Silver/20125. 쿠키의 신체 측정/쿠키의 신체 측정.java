import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static char[][] board;
	static int dr[] = {0, 0, 1};
	static int dc[] = {-1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		int[] head = new int[2];
		int[] heart = new int[2];
		int[] tail = new int[2];
		
		board = new char[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				char now = line.charAt(j);
				board[i][j] = now;
				if(now == '*' && head[0] == 0 && head[1] == 0) {
					head[0] = i;
					head[1] = j;
				}
			}
		}
		
		heart[0] = head[0] + 1;
		heart[1] = head[1];
		
		StringBuilder sb = new StringBuilder();
		sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
		
		sb.append(getLength(heart[0], heart[1], 0)).append(" ");
		sb.append(getLength(heart[0], heart[1], 1)).append(" ");
		int tailLength = getLength(heart[0], heart[1], 2);
		sb.append(tailLength).append(" ");
		tail[0] = heart[0] + tailLength;
		tail[1] = heart[1];
		sb.append(getLength(tail[0], tail[1] - 1, 2)).append(" ");
		sb.append(getLength(tail[0], tail[1] + 1, 2));
		
		System.out.println(sb);
	}
	
	static int getLength(int r, int c, int dir) {
		int cnt = 0;
		while(true) {
			r += dr[dir];
			c += dc[dir];
			if(r < 0 || r >= N || c < 0 || c >= N) break;
			if(board[r][c] == '*') cnt++;
			else break;
		}
		return cnt;
	}
}
