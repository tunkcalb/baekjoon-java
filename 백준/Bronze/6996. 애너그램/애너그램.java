import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			sb.append(A).append(" & ").append(B).append(" ").append("are ");
			
			if(can(A, B)) sb.append("anagrams.");
			else sb.append("NOT anagrams.");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean can(String a, String b) {
		if(a.length() != b.length()) return false;
		int cnt[] = new int[26];
		for(char c : a.toCharArray()) {
			cnt[c - 'a']++;
		}
		
		for(char c : b.toCharArray()) {
			cnt[c - 'a']--;
			if(cnt[c - 'a'] < 0) return false;
		}
		
		return true;
	}
}
