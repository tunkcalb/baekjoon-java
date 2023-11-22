import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] nums;
	static int[] u_dp;
	static int[] d_dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		nums = new int[N];
		u_dp = new int[N];
		d_dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		LTS();
		LDS();
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < u_dp[i] + d_dp[i] - 1) {
				max = u_dp[i] + d_dp[i] - 1;
			}
		}
		System.out.println(max);
	}

	private static void LDS() {
		
		for(int i = N - 1; i >= 0; i--) {
			d_dp[i] = 1;
			
			for(int j = N - 1; j > i; j--) {
				if(nums[i] > nums[j] && d_dp[i] < d_dp[j] + 1) {
					d_dp[i] = d_dp[j] + 1;
				}
			}			
		}
		
	}

	private static void LTS() {
		
		for(int i = 0; i < N; i++) {
			u_dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && u_dp[i] < u_dp[j] + 1) {
					u_dp[i] = u_dp[j] + 1;
				}
			}
		}
		
	}
}
