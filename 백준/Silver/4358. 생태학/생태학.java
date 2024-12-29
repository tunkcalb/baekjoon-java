import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		double cnt = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		String line;
		while((line = in.readLine()) != null) {
			cnt++;
			map.put(line, map.getOrDefault(line, 0) + 1);
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(String key : list) {
			sb.append(key).append(" ").append(String.format("%.4f", map.get(key) / cnt * 100)).append("\n");
		}
		System.out.println(sb);
	}
}
