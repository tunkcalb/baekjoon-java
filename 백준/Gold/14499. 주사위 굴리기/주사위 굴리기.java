import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static int r, c;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	static int[] dice;
	static int[][] board;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[7];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			move(dir);
		}
		
		System.out.println(sb);
	}

	private static void move(int dir) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(nr < 0 || nr >= N || nc < 0 || nc >= M) return;
		
		roll(dir, nr, nc);
		r = nr; c = nc;
	}

	private static void roll(int dir, int nr, int nc) {
		int tmp = dice[3];
		switch(dir) {
		case 1:
			dice[3] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 2:
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = tmp;
			break;
		case 4:
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		
		if(board[nr][nc] == 0) {
			board[nr][nc] = dice[6];
		}
		else {
			dice[6] = board[nr][nc];
			board[nr][nc] = 0;
		}
		sb.append(dice[3]).append("\n");
	}
}
