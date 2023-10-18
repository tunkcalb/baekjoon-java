import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String line = in.readLine();
			if(line.equals("END")) break;
			
			int length = line.length();
			
			for(int i = length - 1; i >= 0; i--) {
				sb.append(line.charAt(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
