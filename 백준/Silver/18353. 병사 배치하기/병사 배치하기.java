import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		int[] dp = new int[N];
		int max = 1;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j = i; j >= 0; j--) {
				if(nums[i] < nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
	}
}
