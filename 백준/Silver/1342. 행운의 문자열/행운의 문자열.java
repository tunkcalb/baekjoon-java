import java.io.*;
import java.util.*;

public class Main {
	
	static int N = 27;
	static int[] alpha;
	static int cnt;
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		len = S.length();
		alpha = new int[N];
		for(int i = 0; i < len; i++) {
			alpha[S.charAt(i) - 'a']++;
		}
		
		dfs(0, ' ');
		System.out.println(cnt);
	}

	private static void dfs(int idx, char pre) {
		if(idx == len) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(alpha[i] == 0) continue;
			
			if(pre != (char) (i + 'a')) {
				alpha[i]--;
				dfs(idx + 1, (char)(i + 'a'));
				alpha[i]++;
			}
		}
	}
}
