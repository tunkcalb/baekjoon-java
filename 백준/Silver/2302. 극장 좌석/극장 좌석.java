import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int M = Integer.parseInt(in.readLine());
		int[] dp = new int[41];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int[] nums = new int[M];
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		int ans = 1;
		
		int now = 0;
		
		for(int next : nums) {
			ans *= dp[next - now - 1];
			now = next;
		}
		ans *= dp[N - now];
		System.out.println(ans);
	}
}
