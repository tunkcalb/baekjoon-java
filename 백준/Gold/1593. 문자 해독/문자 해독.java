import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int W, S;
	static int ans;
	static int cnt;
	static char[] maya;
	static char[] line;
	static HashMap<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		W = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		maya = in.readLine().toCharArray();
		
		for(int i = 0; i < W; i++) {
			char key = maya[i];
			if(!map.containsKey(key)) {
				map.put(key, 1);
			}else {
				map.put(key, map.get(key) + 1);
			}
		}
		line = in.readLine().toCharArray();
		search();
		System.out.println(ans);
	}

	private static void search() {
		
		for(int i = 0; i < W; i++) {
			char key = line[i];
			if(map.containsKey(key)) {
				map.put(key, map.get(key) - 1);
			}
		}
		check();
		move();
	}

	private static void check() {
		for(int i = 0; i < W; i++) {
			if(map.containsKey(line[i])) cnt++;
		}
		count();
	}

	private static void count() {
		if(cnt == W) {
			boolean check = true;
			for(Character c : map.keySet()) {
				if(map.get(c) != 0) {
					check = false;
					break;
				}
			}
			if(check) ans++;
		}
	}

	private static void move() {
		int start = 0;
		int end = W;
		
		for(int i = 0; i < S - W; i++) {
			char skey = line[start];
			char ekey = line[end]; 
			
			if(map.containsKey(skey)) {
				cnt--;
				map.put(skey, map.get(skey) + 1);
			}
			if(map.containsKey(ekey)) {
				cnt++;
				map.put(ekey, map.get(ekey) - 1);
			}
			count();
			start++;
			end++;
		}
	}
}
