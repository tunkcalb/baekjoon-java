import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		Score[] score = new Score[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			score[i] = new Score(k, s);
		}
		
		int[][] dp = new int[N + 1][T + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= T; j++) {
				if(score[i].k <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - score[i].k] + score[i].s);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.println(dp[N][T]);
	}
	
	static class Score {
		int k;
		int s;
		
		Score(int k, int s) {
			this.k = k;
			this.s = s;
		}
	}
}
