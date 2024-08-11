import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int M = 122;
		
		int[] dp1 = new int[M];
		int[] dp2 = new int[M];
		
		dp1[1] = 1;
		dp2[1] = 1;
		
		for(int i = 2; i < M; i++) {
			dp1[i] = dp1[i - 1] + i;
			dp2[i] = dp2[i - 1] + dp1[i];
		}
		
		int[] ans = new int[N + 1];
		
		Arrays.fill(ans, Integer.MAX_VALUE);
		
		ans[0] = 0;
		ans[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < M; j++) {
				if(dp2[j] > i) break;
				ans[i] = Math.min(ans[i], ans[i - dp2[j]] + 1);
			}
		}
		System.out.println(ans[N]);
	}
}
