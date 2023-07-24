import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int max = 0;
		String best = "";
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String book = in.readLine();
			if(!map.containsKey(book)) {
				map.put(book, 1);
				if(max == 0) {
					max = 1;
					best = book;
				}
			}
			map.put(book, map.get(book) + 1);
			if(map.get(book) > max) {
				max = map.get(book);
				best = book;
			}
			if(map.get(book) == max) {
				List<String> list = new ArrayList<>();
				list.add(best);
				list.add(book);
				Collections.sort(list);
				best = list.get(0);
			}
		}
		System.out.println(best);
	}
}
