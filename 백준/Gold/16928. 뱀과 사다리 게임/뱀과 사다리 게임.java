import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int max;
	static int[] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = 101;
		board = new int[max];
		
		for(int i = 1; i < max; i++) {
			board[i] = i;
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		
		int ans = bfs(1);
		System.out.println(ans);
	}

	private static int bfs(int start) {
		int [] dp = new int[max];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		dp[start] = 0;
		
		while(true) {
			int now = q.poll();
			
			for(int i = 1; i < 7; i++) {
				int next = now + i;
				
				if(next > 100) continue;
				
				if(dp[board[next]] == 0) {
					q.offer(board[next]);
					dp[board[next]] = dp[now] + 1;
				}
				
				if(board[next] == 100) return dp[100];
			}
		}
	}
}
