import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			
			for(int j = 0; j < line.length(); j++) {
				if(i == 0) list.add(line.charAt(j));
				else {
					if(list.get(j) != line.charAt(j)) {
						list.set(j, '?');
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char i : list) {
			sb.append(i);
		}
		System.out.println(sb);
	}
}
