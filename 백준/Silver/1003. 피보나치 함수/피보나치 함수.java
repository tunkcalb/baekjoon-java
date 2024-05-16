import java.io.*;
import java.util.*;

public class Main {

	static int[][] dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		dp = new int[40 + 1][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < 2; i++) {
				sb.append(dfs(N, i));
				if (i == 1)
					continue;
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int num, int idx) {
		if (dp[num][idx] != 0)
			return dp[num][idx];
		if (num == 0 || num == 1)
			return 0;
		dp[num][idx] = dfs(num - 1, idx) + dfs(num - 2, idx);
		return dp[num][idx];
	}
}
