import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int P;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		P = Integer.parseInt(st.nextToken());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int idx = 1;
		map.put(num, idx++);
		int now = num;
		int ans = 0;
		while(true) {
			int next = 0;
			String temp = String.valueOf(now);
			for(int i = 0; i < temp.length(); i++) {
				next += pow(temp.charAt(i) - '0');
			}
			if(map.containsKey(next)) {
				ans = map.get(next) - 1;
				break;
			}
			else {
				map.put(next, idx++);
			}
			now = next;
		}
		System.out.println(ans);
		
	}

	private static int pow(int num) {
		int ans = 1;
		for(int i = 0; i < P; i++) {
			ans *= num;
		}
		return ans;
	}
}
