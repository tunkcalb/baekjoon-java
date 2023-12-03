import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		int length = line.length();
		int sum = 10;
		for(int i = 1; i < length; i++) {
			if(line.charAt(i) == line.charAt(i - 1)) sum += 5;
			else sum += 10;
		}
		System.out.println(sum);
	}
}
