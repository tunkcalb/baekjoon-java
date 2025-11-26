import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, List<String>> map = new HashMap<>();
		Map<String, String> members = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String group = br.readLine();
			
			int size = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < size; j++) {
				String member = br.readLine();
				
				if(map.containsKey(group)) {
					List<String> list = map.get(group);
					list.add(member);
					map.put(group, list);
				}
				else {
					List<String> list = new ArrayList<>();
					list.add(member);
					map.put(group, list);
				}
				members.put(member, group);
			}
			
		}
		
		for(int i = 0; i < M; i++) {
			String quize = br.readLine();
			int category = Integer.parseInt(br.readLine());
			
			if(category == 1) {
				sb.append(members.get(quize)).append("\n");
			}
			else {
				List<String> list = map.get(quize);
				
				Collections.sort(list);
				
				for(String member : list) {
					sb.append(member).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
