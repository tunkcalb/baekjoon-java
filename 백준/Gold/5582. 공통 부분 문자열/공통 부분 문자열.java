import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = in.readLine().toCharArray();
		char[] str2 = in.readLine().toCharArray();

		int len1 = str1.length;
		int len2 = str2.length;

		int[][] dp = new int[len1 + 1][len2 + 1];

		int max = 0;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {

				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
