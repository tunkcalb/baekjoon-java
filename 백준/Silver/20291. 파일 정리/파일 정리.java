import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), ".");
			
			st.nextToken();
			
			String extension = st.nextToken();
			
			if(map.containsKey(extension)) {
				map.put(extension, map.get(extension) + 1);
			}
			else {
				map.put(extension, 1);
				list.add(extension);
			}
		}
		
		Collections.sort(list);
		
		for(String key : list) {
			System.out.println(key + " " + map.get(key));
		}
		
	}
}
