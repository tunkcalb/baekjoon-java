import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			String line = in.readLine();
			int len = line.length();
			sb.append(line.charAt(0));
			sb.append(line.charAt(len - 1));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
