import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String line = in.readLine();
		int max = 1111111111;
		int[] dp = new int[N];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for(int i = 0; i < N - 1; i++) {
			char now = line.charAt(i);
			switch(now) {
			case 'B':
				for(int j = i + 1; j < N; j++) {
					if(line.charAt(j) == 'O') {
						dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
					}
				}
				break;
			case 'O':
				for(int j = i + 1; j < N; j++) {
					if(line.charAt(j) == 'J') {
						dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
					}
				}
				break;
			case 'J':
				for(int j = i + 1; j < N; j++) {
					if(line.charAt(j) == 'B') {
						dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
					}
				}
				break;
			}
		}
		if(dp[N - 1] == max) System.out.println(-1);
		else System.out.println(dp[N - 1]);
	}
}
