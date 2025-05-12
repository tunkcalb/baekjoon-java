import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, r;
	static int INF = 300000;
	static int[] items;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		board = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(board[i], INF);
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			board[a][b] = Math.min(board[a][b], l);
			board[b][a] = board[a][b];
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(board[i][j] > board[i][k] + board[k][j]) board[i][j] = board[i][k] + board[k][j];
				}
			}
		}
		int max = 0;
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				if(i == j) sum += items[j];
				else if(board[i][j] <= m) sum += items[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
