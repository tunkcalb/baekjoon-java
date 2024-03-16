import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static HashSet<String> set;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		set = new HashSet<>();
		cnt = 0;
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			if(set.isEmpty() || !has(line)) {
				cnt++;
				set.add(line);
			}
		}
		System.out.println(cnt);
	}

	private static boolean has(String line) {
		String newLine = line;
		for(int i = 0; i < line.length(); i++) {
			newLine = newLine.substring(1,newLine.length()) + newLine.charAt(0);
			if(set.contains(newLine)) {
				return true;
			}
		}
		return false;
	}
}
