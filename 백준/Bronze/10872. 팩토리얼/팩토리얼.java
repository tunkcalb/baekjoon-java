import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[13];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= 12; i++) {
			dp[i] = dp[i - 1] * i;
		}
		System.out.println(dp[N]);
	}
}
