import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int blue, white;
	private static int[][] board;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int size = N;
		cut(0,0,size);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cut(int row, int col, int size) {
		int sum = 0;
		for(int i = row; i < row +size; i++) {
			for(int j = col; j < col + size; j++) {
				sum += board[i][j];
			}
		}
		if(sum == 0) {
			white++;
			return;
		}
		if(sum == size*size) {
			blue++;
			return;
		}
		
		
		
		
		size /= 2;
		
		
		//좌상
		cut(row, col, size);
		//우상
		cut(row, col + size, size);
		//좌하
		cut(row + size, col, size);
		//우하
		cut(row + size, col + size, size);
		
		
	}
}