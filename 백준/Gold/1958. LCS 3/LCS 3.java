import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine();
		String B = in.readLine();
		String C = in.readLine();
		
		int lenA = A.length();
		int lenB = B.length();
		int lenC = C.length();
		
		int[][][] dp = new int[lenA + 1][lenB + 1][lenC + 1];
		
		for(int i = 1; i <= lenA; i++) {
			char a = A.charAt(i - 1);
			for(int j = 1; j <= lenB; j++) {
				char b = B.charAt(j - 1);
				for(int k = 1; k <= lenC; k++) {
					char c = C.charAt(k - 1);
					if(a == b && b == c) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					}
					else dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					
				}
			}
		}
		System.out.println(dp[lenA][lenB][lenC]);
	}
}
