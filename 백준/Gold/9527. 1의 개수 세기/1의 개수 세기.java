import java.io.*;
import java.util.*;

public class Main {
	
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[55];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		dp[0] = 1;
		
		for(int i = 1; i < 55; i++) {
			dp[i] = (dp[i - 1] << 1) + (1L << i);
		}
		
		long ans = cal(M) - cal(N - 1);
		System.out.println(ans);
	}

	private static long cal(long n) {
		long cnt = n & 1;
		int size = (int) (Math.log(n) / Math.log(2));
		
		for(int i = size; i > 0; i--) {
			if((n & (1L << i)) != 0L) {
				cnt += dp[i - 1] + (n - (1L << i) + 1);
				n -= (1L << i);
			}
		}
		return cnt;
	}
}
