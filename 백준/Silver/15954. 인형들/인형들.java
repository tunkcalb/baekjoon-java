import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		nums = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		double ans = Double.MAX_VALUE;
		double ret = 0;
		
		for(int i = K; i <= N; i++) {
			for(int j = 0; j <= N - i; j++) {
				double m = mean(j, i);
				ret = variance(m, j, i);
				ans = Math.min(ans , ret);
			}
		}
		System.out.println(ans);
	}
	private static double variance(double m, int start, int k) {
		double sum = 0.0;
		for(int i = 0; i < k; i++) {
			sum += Math.pow(nums[start + i] - m, 2);
		}
		return Math.sqrt(sum / k);
	}
	private static double mean(int start, int k) {
		double sum = 0.0;
		for(int i = 0; i < k; i++) {
			sum += nums[start + i];
		}
		return sum / k;
	}	
}
