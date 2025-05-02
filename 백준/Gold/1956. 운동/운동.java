import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[V + 1][V + 1];
		
		for(int i = 1; i <= V; i++) {
			Arrays.fill(board[i],INF);
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[a][b] = c;
		}
		
		for(int k = 1; k <= V; k++) {
			for(int i = 1; i <= V; i++) {
				for(int j = 1; j <= V; j++) {
					if(board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(i == j) continue;
				
				if(board[i][j] != INF && board[j][i] != INF) {
					ans = Math.min(ans,  board[i][j] + board[j][i]);
				}
			}
		}
		
		System.out.println(ans == INF ? -1 : ans);
	}
}
