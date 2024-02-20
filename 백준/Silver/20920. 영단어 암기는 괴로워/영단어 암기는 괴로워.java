import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String word = in.readLine();
			
			if(word.length() < M) continue;
			
			if(map.containsKey(word)) map.put(word, map.get(word) + 1);
			else map.put(word, 1);
		}
		List<Word> list = new ArrayList<>();
		map.forEach((key, value) -> {
			list.add(new Word(key, value));
		});
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Word word : list) {
			sb.append(word.word).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Word implements Comparable<Word>{
		String word;
		int cnt;
		
		Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Word o) {
			if(this.cnt != o.cnt) return o.cnt - this.cnt;
			if(this.word.length() != o.word.length()) return o.word.length() - this.word.length();
			return this.word.compareTo(o.word);
		}
	}
}
