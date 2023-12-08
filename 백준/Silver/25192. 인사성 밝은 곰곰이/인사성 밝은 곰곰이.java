import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			if(line.equals("ENTER")) {
				set = new HashSet<>();
			}
			else {
				if(!set.contains(String.valueOf(line))) {
					sum += 1;
					set.add(line);
				}
			}
		}
		System.out.println(sum);
		
	}
}
