import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		int ans = 0;
		for(int i = 0; i < len; i++) {
			String sub = str.substring(i, len);
			ans = Math.max(ans, kmp(sub));
		}
		System.out.println(ans);
	}

	private static int kmp(String str) {
		int j = 0;
		int max = 0;
		int n = str.length();
		int[] pi = new int[n];
		
		for(int i = 1; i < n; i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(str.charAt(i) == str.charAt(j)) {
				pi[i] = ++j;
				max = Math.max(max, pi[i]);
			}
		}
		return max;
	}
}
