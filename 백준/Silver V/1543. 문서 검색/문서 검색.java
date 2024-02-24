import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		int len = line.length();
		int idx = 0;
		int cnt = 0;
		String word = in.readLine();
		int size = word.length();
		
		start : while(idx < len) {
			for(int i = 0; i < size; i++) {
				if(idx + i >= len) break start;
				if(line.charAt(idx + i) != word.charAt(i)) {
					idx ++;
					continue start;
				}
			}
			idx += size;
			cnt++;
		}
		System.out.println(cnt);
	}
}
