import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String S = in.readLine();
		String T = in.readLine();

		System.out.println(dfs(S, T));
	}

	private static int dfs(String s, String t) {
		
		if(s.length() == t.length()) {
			if(s.equals(t)) {
				return 1;
			}
			return 0;
		}
		
		int ans = 0;
		if(t.charAt(0) == 'B') {
			String substring = t.substring(1);
			StringBuilder sb = new StringBuilder(substring);
			String string = sb.reverse().toString();
			ans += dfs(s, string);
		}
		
		if(t.charAt(t.length() - 1) == 'A') {
			ans += dfs(s, t.substring(0, t.length() - 1));
		}
		return ans > 0 ? 1 : 0;
	}
}
