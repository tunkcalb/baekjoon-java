import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = i; j <= N; j++) {
				if(dp[j] < dp[j - i] + nums[i]) dp[j] = dp[j - i] + nums[i];
			}
		}
		
		System.out.println(dp[N]);
	}
}
