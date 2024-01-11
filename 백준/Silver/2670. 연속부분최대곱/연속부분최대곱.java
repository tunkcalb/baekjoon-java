import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		double[] dp = new double[N + 1];
		double[] nums = new double[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Double.parseDouble(in.readLine());
		}
		
		double max = 0;
		for(int i = 1; i <= N; i++) {
			dp[i] = nums[i];
			double num = dp[i - 1] * nums[i];
			if(num > dp[i]) {
				dp[i] = num;
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(String.format("%.3f",max));
	}
}
