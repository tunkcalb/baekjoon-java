import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		int N = line.length();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N / 10; i++) {
			for(int j = 0; j < 10; j++) {
				sb.append(line.charAt(i * 10 + j));
			}
			sb.append("\n");
		}
		
		for(int i = 0; i < N % 10; i++) {
			sb.append(line.charAt((N / 10) * 10 + i));
		}
		
		System.out.println(sb);
	}
}
