import java.io.*;
import java.util.*;

public class Main {
	
	static int[] board;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int max = 10000;

		board = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
			dp[i] = max;
		}
		dp[0] = 0;
		for(int i = 0; i < N; i++) {
			int num = board[i];
			
			for(int j = 1; j <= num; j++) {
				if(i + j >= N) break;
				if(dp[i + j] > dp[i] + 1) dp[i + j] = dp[i] + 1;
			}
		}
		
		if(dp[N - 1] == max) dp[N - 1] = -1;
		System.out.println(dp[N - 1]);
	}
}
