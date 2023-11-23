import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
