import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static boolean[] visited;
	static int N, M;
	static int max = Integer.MAX_VALUE;
	static int min;
	static int start, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(board[i], max);
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int num = Integer.parseInt(st.nextToken());
			
			board[a][b] = num;
			board[b][a] = num;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1]; 
			visited[start] = true;
			min = max;
			dfs(start, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int now, int sum) {
		if(now == end) {
			min = Math.min(sum, min);
			return;
		}
		
		for(int next = 1; next <= N; next++) {
			if(!visited[next] && board[now][next] != max) {
				visited[next] = true;
				dfs(next, sum + board[now][next]);
			}
		}
	}
}
