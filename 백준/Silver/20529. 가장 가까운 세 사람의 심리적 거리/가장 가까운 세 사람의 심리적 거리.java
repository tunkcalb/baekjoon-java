import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			String[] mbti = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			
			if(33 <= N) {
				System.out.println(0);
				continue;
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < mbti.length; i++) {
				for(int j = i + 1; j < mbti.length; j++) {
					for(int k = j + 1; k < mbti.length; k++) {
						int cnt = distance(mbti[i], mbti[j], mbti[k]);
						min = Math.min(cnt, min);
					}
				}
			}
			System.out.println(min);
		}
	}

	private static int distance(String str1, String str2, String str3) {
		
		int cnt = 0;
		for(int i = 0; i < str1.length(); i++) {
			char char1 = str1.charAt(i);
			char char2 = str2.charAt(i);
			char char3 = str3.charAt(i);
			
			if(char1 != char2) cnt++;
			if(char2 != char3) cnt++;
			if(char3 != char1) cnt++;
		}
		return cnt;
	}
}
