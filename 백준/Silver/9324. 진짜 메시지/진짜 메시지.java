import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		time : for(int i = 0; i < N; i++) {
			int[] cnt = new int[26];
			String line = br.readLine();
			
			int len = line.length();
			
			for(int j = 0; j < len; j++) {
				int now = line.charAt(j) - 'A';
				cnt[now]++;
				
				if(cnt[now] == 3) {
					if(j == len - 1 || line.charAt(j + 1) - 'A' != now) {
						sb.append("FAKE").append("\n");
						continue time;
					}
					j++;
					cnt[now] = 0;
				}
			}
			
			sb.append("OK").append("\n");
		}
		System.out.println(sb);
	}
}
