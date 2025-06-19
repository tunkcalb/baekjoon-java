import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int len = line.length();
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < len; i++) {
			char now = line.charAt(i);
			
			if(map.containsKey(now)) continue;
			map.put(now, i);
		}
		
		char key = 'a';
		
		StringBuilder sb = new StringBuilder();
		
		while(key <= 'z') {
			int idx = map.getOrDefault(key, -1);
			
			sb.append(idx).append(" ");
			key = (char) (key + 1);
		}
		
		System.out.println(sb);
	}
}
