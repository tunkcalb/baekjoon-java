import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int nums[] = new int [N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1];
		int max = 1;
		
		for(int i = 1 ; i <= N; i++) {
			dp[i] = 1;
			for(int j = 1; j < i; j++) {
				if(nums[j] > nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
		
	}
}
