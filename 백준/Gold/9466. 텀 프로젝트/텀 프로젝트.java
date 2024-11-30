import java.io.*;
import java.util.*;

public class Main {
	
	static int[] board;
	static boolean[] visited;
	static boolean[] done;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(in.readLine());
			board = new int[n + 1];
			visited = new boolean[n + 1];
			done = new boolean[n + 1];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int i = 1; i <= n; i++) {
				board[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= n; i++) {
				if(!done[i]) {
					dfs(i);
				}
			}
			sb.append(n - cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int n) {
		if(visited[n]) {
			done[n] = true;
			cnt++;
		} else {
			visited[n] = true;
		}
		
		if(!done[board[n]]) {
			dfs(board[n]);
		}
		
		visited[n] = false;
		done[n] = true;
	}
}
