import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int R, C, N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = in.readLine();
			for(int j = 0; j < C; j++) {
				board[i] = line.toCharArray();
			}
		}
		
		if(N % 2 == 0) {
			even();
		}else if (N == 1) {
			print();
		}else if((N - 1) % 4 == 0) {
			odd2();
			print();
		}else {
			odd1();
			print();
		}
		
		System.out.println(sb);
		
	}

	private static void odd2() {
		odd1();
		odd1();
		
	}

	private static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
	}

	private static void odd1() {
		char[][] board2 = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				board2[i][j] = 'O';
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] == 'O') {
					board2[i][j] = '.';
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
							board2[nr][nc] = '.';
						}
					}
				}
			}
		}
		board = board2;	
	}

	private static void even() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append("O");
			}
			sb.append("\n");
		}
		
	}
}