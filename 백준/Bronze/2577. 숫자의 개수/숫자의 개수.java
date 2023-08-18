import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 1;
		
		for(int i = 0; i < 3; i++) {
			num *= Integer.parseInt(in.readLine());
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i <= 9; i++) {
			map.put(i, 0);
		}
		
		String number = num + "";
		int length = number.length();
		for(int i = 0; i < length; i++) {
			int idx = number.charAt(i) - '0';
			map.put(idx, map.get(idx) + 1);
		}
		
		for(int i = 0; i <= 9; i++) {
			System.out.println(map.get(i));
		}
	}
}
