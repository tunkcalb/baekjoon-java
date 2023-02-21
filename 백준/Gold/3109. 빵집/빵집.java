import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int cnt;
	
	private static int[][] board;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == 'x'){
					board[i][j] = 1;
				}
				else board[i][j] = 0;
				
			}
		}

		for(int i = 0; i < N; i++) {
			if(pipe(i, 0)) cnt++;
		}
		
		System.out.println(cnt);
		

	}

	private static boolean pipe(int row, int col) {
		board[row][col] = 1;
		
		if(col == M-1) {
			return true;
		}
		
		
		if(row > 0 && board[row-1][col+1] == 0) //오른쪽 위
			if(pipe(row - 1, col + 1))
				return true;
		
		if(board[row][col + 1] == 0) //오른쪽
			if(pipe(row, col + 1))
				return true;
		
		if(row + 1 < N && board[row + 1][col + 1] == 0) //오른쪽 아래
			if(pipe(row + 1, col + 1))
				return true;
		return false;
		
	}

}