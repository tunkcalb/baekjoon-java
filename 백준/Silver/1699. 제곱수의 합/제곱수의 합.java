import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			dp[i] = i;
			for(int j = 1; j * j <= i; j++) {
				if(dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
