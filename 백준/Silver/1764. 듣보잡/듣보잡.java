import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		List<String> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String name = in.readLine();
			map.put(name, 1);
		}
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			String name = in.readLine();
			if(map.containsKey(name)) {
				cnt++;
				list.add(name);
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
