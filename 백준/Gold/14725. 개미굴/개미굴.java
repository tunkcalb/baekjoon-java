import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Trie root = new Trie("");
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int K = Integer.parseInt(st.nextToken());
			Trie now = root;
			for(int k = 0; k < K; k++) {
				String food = st.nextToken();
				HashMap<String, Trie> map = now.map;
				if(!map.containsKey(food)) {
					Trie next = new Trie(food);
					map.put(food, next);
					now = next;
				}
				else {
					now = map.get(food);
				}
			}
			
		}
		dfs(root, -1);
		System.out.println(sb);
	}
	
	private static void dfs(Trie now, int cnt) {
		
		if(cnt >= 0) {
			for(int i = 0; i < cnt; i++) {
				sb.append("--");				
			}
			sb.append(now.food).append("\n");
		}
		HashMap<String, Trie> map = now.map;
		List<String> keys = new ArrayList<>(map.keySet());
		
		Collections.sort(keys);
		
		for(String key : keys) {
			Trie next = map.get(key);
			dfs(next, cnt + 1);
		}
	}

	static class Trie {
		String food;
		HashMap<String, Trie> map;
		
		Trie(String food) {
			this.food = food;
			map = new HashMap<>();
		}
	}
}
