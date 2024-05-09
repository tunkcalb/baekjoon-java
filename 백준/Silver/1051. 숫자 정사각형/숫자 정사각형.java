import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int ans;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		int len = Math.min(N, M);
		
		while(len > 1) {
			for(int i = 0; i <= N - len; i++) {
				for(int j = 0; j <= M - len; j++) {
					int num = board[i][j];
					
					if(num == board[i][j + len - 1] && num == board[i + len -1][j] && num == board[i + len - 1][j + len - 1]) {
						System.out.println(len * len);
						return;
					}
				}
			}
			len--;
		}
		System.out.println(len * len);
	}
}
