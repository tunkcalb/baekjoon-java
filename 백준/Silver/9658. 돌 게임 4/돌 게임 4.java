import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[1001];
		dp[1] = 2;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 1;
		for(int i = 5; i <= N; i++) {
			dp[i] = 2;
			if (dp[i - 1] == 2 || dp[i - 3] == 2 || dp[i - 4] == 2) dp[i] = 1;
		}
		if(dp[N] == 1) {
			System.out.println("SK");
		}
		else System.out.println("CY");	
	}
}
