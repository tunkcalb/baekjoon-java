import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N + 1][K + 1];
		int[][] items = new int[N + 1][2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			int[] item = items[i];
			for(int j = 1; j <= K; j++) {
				if(j < item[0]) {
					board[i][j] = board[i - 1][j];
				}
				else {
					board[i][j] = Math.max(board[i - 1][j - item[0]] + item[1],board[i - 1][j]);
				}
			}
		}
		
		System.out.println(board[N][K]);
		
	}
}