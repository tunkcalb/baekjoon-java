import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer, Integer> map = new HashMap<>();

		int N = 9;
		for(int i = 0; i <= N; i++) {
			map.put(i, 0);
		}
		String line = in.readLine();
		
		for(int i = 0; i < line.length(); i++) {
			int num = line.charAt(i) - '0';
			map.put(num, map.get(num) + 1);
		}
		map.put(6, (map.get(6) + map.get(9) + 1) / 2);
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, map.get(i));
		}
		System.out.println(max);
	}
}
