import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] nums = new int[N + 1][2];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);
		
		int[] dp = new int[N + 1];
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			dp[i] = 1;
			for(int j = i; j > 0; j--) {
				if(nums[j][1] < nums[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}		
			
			max = Math.max(max,dp[i]);
		}
		
		System.out.println(N - max);
	}
}
