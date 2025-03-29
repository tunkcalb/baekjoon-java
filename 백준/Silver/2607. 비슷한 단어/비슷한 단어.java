import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = 26;
		String first = br.readLine();
		int ans = 0;
		
		for(int i = 0; i < N - 1; i++) {
			String line = br.readLine();
			int cnt = 0;
			int[] word = new int[M];
			for(int j = 0; j < first.length(); j++) {
				word[first.charAt(j) - 'A']++;
			}
			
			for(int j = 0; j < line.length(); j++) {
				if(word[line.charAt(j) - 'A'] > 0) {
					cnt++;
					word[line.charAt(j) - 'A']--;
				}
			}
			
			if(first.length() == line.length()) {
				if(first.length() == cnt || first.length() - 1 == cnt) {
					ans++;
				}
			}else if (first.length() == line.length() - 1) {
				if(line.length() - 1 == cnt) {
					ans++;
				}
			}else if (first.length() == line.length() + 1) {
				if(line.length() == cnt) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
