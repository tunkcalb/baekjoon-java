import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		int[] num = new int[n + 1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {

			for (int j = i - 1; j >= 0; j--) {
				if (num[i] > num[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
