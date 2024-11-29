import java.io.*;
import java.util.*;

public class Main {
	
	static TreeSet<String> set;
	static int[] alpha;
	static char[] comb;
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			set = new TreeSet<>();
			String line = in.readLine();
			len = line.length();
			alpha = new int[26];
			comb = new char[len];
			for(int j = 0; j < len; j++) {
				alpha[line.charAt(j) - 'a']++;
			}
			
			combination(0);
			for(String word : set) {
				sb.append(word).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static void combination(int idx) {
		if(idx == len) {
			StringBuilder anagram = new StringBuilder();
			
			for(int i = 0; i < len; i++) {
				anagram.append(comb[i]);
			}
			set.add(anagram.toString());
			return;
		}
		
		for(int i = 0; i < 26; i++) {
			if(alpha[i] > 0) {
				alpha[i]--;
				comb[idx] = (char) (i + 'a');
				combination(idx + 1);				
				alpha[i]++;
			}
		}
		
	}
}
