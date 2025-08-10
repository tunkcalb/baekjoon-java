import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			char now = line.charAt(0);
			
			map.put(now, map.getOrDefault(now, 0) + 1);
		}
		
		List<Character> list = new LinkedList<>();
		
		Set<Character> keys = map.keySet();
		
		for(char key : keys) {
			if(map.get(key) >= 5 ) list.add(key);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		if(list.size() > 0) {
			for(char now : list) {
				sb.append(now);
			}
		} else {
			sb.append("PREDAJA");
		}
		
		System.out.println(sb);
	}
}
