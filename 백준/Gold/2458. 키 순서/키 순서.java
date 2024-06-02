import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int INF = 10000000;
		
		int[][] board = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				board[i][j] = INF;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			board[A][B] = 0;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 0; i <= N; i++) {
				for(int j = 0; j <= N; j++) {
					board[i][j] = Math.min(board[i][k] + board[k][j], board[i][j]);
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			for(int j = 1; j <= N; j++) {
				if(board[i][j] == 0 || board[j][i] == 0) cnt++;
			}
			if(cnt == N - 1) ans++;
		}
		System.out.println(ans);
	}
}
