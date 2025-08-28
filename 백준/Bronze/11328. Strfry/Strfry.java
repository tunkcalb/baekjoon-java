import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String answer = strfry(st.nextToken(), st.nextToken());
            sb.append(answer).append("\n");
        }
		
		System.out.println(sb);
	}

	private static String strfry(String a, String b) {
		if(a.length() != b.length()) return "Impossible";
		
		int N = 26;
		
		int[] cnt = new int[N];
		
		for(int i = 0; i < a.length(); i++) {
			cnt[a.charAt(i) - 'a']++;
			cnt[b.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < N; i++) {
			if(cnt[i] != 0) return "Impossible";
		}
		return "Possible";
	}
}
