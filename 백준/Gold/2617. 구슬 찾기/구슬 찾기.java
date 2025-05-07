import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			board[a][b] = 1;
			board[b][a] = -1;
		}
		
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(board[i][k] != 0 && board[i][k] == board[k][j]) board[i][j] = board[i][k];
				}
			}
		}
		
		
		int[] big = new int[N + 1];
		int[] small = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(board[i][j] == 1) big[i]++;
				if(board[i][j] == -1) small[i]++;
			}
		}
		
		int cnt = 0;
		int half = (N / 2) + 1;
		for(int i = 1; i <= N; i++) {
			if(big[i] >= half) cnt++;
			if(small[i] >= half) cnt++;
		}
		
		System.out.println(cnt);
	}
}
