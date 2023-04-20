import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int N = 5;
	static int M = 9;
	static int size;
	static char[][] board;
	
	static int dr[][] = {{1,1,1,1},{3,3,3,3},{0,1,2,3},{0,1,2,3},{1,2,3,4},{1,2,3,4}};
	static int dc[][] = {{1,3,5,7},{1,3,5,7},{4,3,2,1},{4,5,6,7},{1,2,3,4},{7,6,5,4}};
	
	static List<Point> list = new ArrayList<>();
	static boolean[] visited = new boolean[13];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		board = new char[N][M];
		for(int i = 0; i < 5; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'x') list.add(new Point(i,j));
				else if(board[i][j] != '.') {
					visited[board[i][j] - 'A' + 1] = true;
				}
			}
		}
		size = list.size();
		dfs(0);
		
	}

	private static void dfs(int cnt) {
		
		if(cnt == size) {
			if(!isMagicStar()) return;
			print();
		}
		
		for(int i = 1; i <= 12; i++) {
			if(!visited[i]) {
				visited[i] = true;
				board[list.get(cnt).r][list.get(cnt).c] = (char) ('A' + i - 1);
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
		
	}

	private static boolean isMagicStar() {
		for(int i = 0; i < 6; i++) {
			int sum = 0;
			for(int j = 0; j < 4; j++) {
				int r = dr[i][j];
				int c = dc[i][j];
				sum += board[r][c] - 'A' + 1;
			}
			if(sum != 26) return false;
		}
		return true;
	}

	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		System.exit(0);
	}
}
