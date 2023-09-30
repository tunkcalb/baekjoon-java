import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			
			sum = cal(num);
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.println(sb);
	}

	private static int cal(int num) {
		if(num <= 3) return num;
		
		int[][] dp  = new int[num + 1][4];
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4; i <= num; i++) {
			dp[i][1] = 1;
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2]  + dp[i - 3][3];
		}
		return dp[num][1] + dp[num][2] + dp[num][3];
	}
}
