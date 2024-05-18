import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine().toUpperCase();
		
		int[] cnt = new int[26];
		
		for(int i = 0; i < line.length(); i++) {
			int num = line.charAt(i) - 'A';
			cnt[num]++;
		}
		
		int max = 0;
		char ans = '?';
		for(int i = 0; i < cnt.length; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
				ans = (char)(i + 'A');
			} else if (max == cnt[i]) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
