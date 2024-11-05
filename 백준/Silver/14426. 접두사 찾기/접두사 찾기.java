import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Trie head = new Trie();
		
		for(int i = 0; i < N; i++) {
			String word = in.readLine();
			Trie idx = head;
			for(int j = 0; j < word.length(); j++) {
				char alpha = word.charAt(j);
				if(!idx.child.containsKey(alpha)) {
					idx.child.put(alpha, new Trie(alpha));
				}
				idx = idx.child.get(alpha);
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			String word = in.readLine();
			Trie idx = head;
			for(int j = 0; j < word.length(); j++) {
				char alpha = word.charAt(j);
				
				if(!idx.child.containsKey(alpha)) break;
				idx = idx.child.get(alpha);
				if(j == word.length() - 1) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static class Trie {
		char alpha;
		Map<Character, Trie> child = new HashMap<>();
		
		public Trie(char alpha) {
			this.alpha = alpha;
		}
		
		public Trie() {}
	}
}
