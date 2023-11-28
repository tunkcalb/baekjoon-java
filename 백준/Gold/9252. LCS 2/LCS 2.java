import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = in.readLine().toCharArray();
        char[] str2 = in.readLine().toCharArray();
		
		int a_len = str1.length;
		int b_len = str2.length;
		
		dp = new int[a_len + 1][b_len + 1];		
		for(int i = 1; i <= a_len; i++) {
			for(int j = 1; j <= b_len; j++) {
				if(str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;

				}else {
					if(dp[i - 1][j] < dp[i][j - 1]) {
						dp[i][j] = dp[i][j - 1];
					}
					else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
			
		}
		getString(str1, a_len, b_len);
		System.out.println(dp[a_len][b_len]);
		System.out.println(sb);
		
	}
	static void getString(char[] str, int i, int j) {
        Stack<Character> stack = new Stack<>();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
            	stack.push(str[i-1]);
                i--;
                j--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
