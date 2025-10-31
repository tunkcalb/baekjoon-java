import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N + 2][2];
		int[] dp = new int[N + 2];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			board[i][0] = t;
			board[i][1] = p;
		}
		
		int max = 0;
		for(int i = 1; i <= N + 1; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int next = i + board[i][0];
			if(next < N + 2) {
				dp[next] = Math.max(dp[next], max + board[i][1]);
			}
		}
		
		System.out.println(max);
	}
}
