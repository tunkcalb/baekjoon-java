import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int M = 100 * 9;
		
		long[][] dp = new long[N][M + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		dp[0][Integer.parseInt(st.nextToken())] = 1;
		
		for(int i = 0; i < N - 2; i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < M; j++) {
				long now = dp[i][j];
				if(now != 0) {
					if(j - num >= 0) dp[i + 1][j - num] += now;
					if(j + num <= 20) dp[i + 1][j + num] += now;
				}
			}
		}
		System.out.println(dp[N - 2][Integer.parseInt(st.nextToken())]);
	}
}
