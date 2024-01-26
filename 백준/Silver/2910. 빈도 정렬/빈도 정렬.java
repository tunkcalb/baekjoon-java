import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		List<Integer> origin = new ArrayList<>();
		
		st = new StringTokenizer(in.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			origin.add(num);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		list.sort((o1, o2) -> {
			if(map.get(o1) == map.get(o2)) {
				return origin.indexOf(o1) - origin.indexOf(o2);
			} else {
				return Integer.compare(map.get(o2), map.get(o1));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb);
	}
}
