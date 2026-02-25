import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String card = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			
			map.put(card, map.getOrDefault(card, 0) + cnt);
		}
		
		String ans = "NO";
		for(String key : map.keySet()) {
			if(map.get(key) == 5) {
				ans = "YES";
				break;
			}
		}
		
		System.out.println(ans);
	}
}
