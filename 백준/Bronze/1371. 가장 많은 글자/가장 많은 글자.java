import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 'z' - 'a' + 1;
		int[] cnt = new int[N];
		
		int max = 0;
		String line;
		
		while((line = br.readLine()) != null) {
			int len = line.length();
			
			for(int i = 0; i < len; i++) {
				char now = line.charAt(i);
				if(now == ' ') continue;
				
				cnt[now - 'a']++;
				
				if(cnt[now - 'a'] > max) {
					max = cnt[now - 'a'];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			if(cnt[i] == max) {
				sb.append((char) (i + 'a'));
			}
		}
		
		System.out.println(sb);
	}
}
