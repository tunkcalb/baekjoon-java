import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int min;
	static int[][] board;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][k] + board[k][j] < board[i][j])
						board[i][j] = board[i][k] + board[k][j];
				}
			}
		}
		
		visited = new boolean[N];
		visited[K] = true;
		min = Integer.MAX_VALUE;
		dfs(1, K, 0);
		System.out.println(min);
	}

	private static void dfs(int cnt, int now, int sum) {
		if(cnt == N) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int next = 0; next < N; next++) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(cnt + 1, next, sum + board[now][next]);
			visited[next] = false;
		}
	}
}
