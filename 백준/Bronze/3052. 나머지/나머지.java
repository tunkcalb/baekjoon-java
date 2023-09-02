import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 10;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			num %= 42;
			if(!map.containsKey(num)) map.put(num, 1);
		}
		System.out.println(map.size());
		
	}
}
