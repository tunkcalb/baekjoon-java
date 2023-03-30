import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int[][] board;
	
	static int N, M;
	
	static List<int[]> list;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = 9;
		M = 3;
		board = new int[N][N];
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j) - '0';
				if(board[i][j] == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		start(0);
		
	}

	private static void start(int idx) {
		
		if(idx == list.size()) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		
		boolean check[] = new boolean[N + 1];
		
		for(int i = 0; i < N; i++) {
			if(board[r][i] != 0) {
				check[board[r][i]] = true;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(board[i][c] != 0) {
				check[board[i][c]] = true;
			}
		}
		
		int nr = (r / 3) * 3;
		int nc = (c / 3) * 3;
		
		for(int i = nr; i < nr + M; i++) {
			for(int j = nc; j < nc + M; j++) {
				if(board[i][j] != 0) {
					check[board[i][j]] = true;					
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(!check[i]) {
				board[r][c] = i;
				start(idx + 1);
				board[r][c] = 0;
			}
		}
		
		
		
	}
}