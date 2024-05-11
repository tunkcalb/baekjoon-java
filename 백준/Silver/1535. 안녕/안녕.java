import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int K = 99;
		int[] life = new int[N + 1];
		int[] happy = new int[N + 1];
		
		int[][] dp = new int[N + 1][K + 1];

		StringTokenizer st1 = new StringTokenizer(in.readLine());
		StringTokenizer st2 = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			life[i] = Integer.parseInt(st1.nextToken());
			happy[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1 ; j <= K; j++) {
				if(life[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j - life[i]] + happy[i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
