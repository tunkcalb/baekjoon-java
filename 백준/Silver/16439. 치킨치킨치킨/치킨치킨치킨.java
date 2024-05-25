import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int ans;
	static boolean[] visited;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		visited = new boolean[m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j <m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		dfs(0, 0);
		System.out.println(ans);
		
	}
	private static void dfs(int start, int idx) {
		if(idx == 3) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				int temp = 0;
				for(int j = 0; j < m; j++) {
					if(visited[j]) {
						temp = Math.max(temp, board[i][j]);
					}
				}
				sum += temp;
			}
			ans = Math.max(sum, ans);
			return;
		}
		for(int i = start; i < m; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i + 1, idx + 1);
				visited[i] = false;
			}
		}
	}
}
