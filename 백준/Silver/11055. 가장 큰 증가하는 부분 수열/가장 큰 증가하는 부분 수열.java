import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			dp[i] = nums[i];
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && dp[j] + nums[i]> dp[i]) {
					dp[i] = dp[j] + nums[i];
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
