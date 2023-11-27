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
		
		int[] dp = new int[N];
		String[] ans = new String[N];
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			ans[i] = nums[i] + "";
			for(int j = 0; j < i; j++) {
				if(dp[i] < dp[j] + 1 && nums[i] > nums[j]) {
					dp[i] = dp[j] + 1;
					ans[i] = ans[j] + " " + nums[i];
				}
			}
		}
		int max = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(max < dp[i]) {
				max = dp[i];
				idx = i;
			}
		}
		System.out.println(dp[idx]);
		System.out.println(ans[idx]);
	}
}
