import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String num = in.readLine();
			
			if(num.equals("0")) break;
			
			int length = num.length();
			
			boolean isValid = true;
			
			for(int i = 0; i < length / 2; i++) {
				if(num.charAt(i) != num.charAt(length - 1 - i)) {
					isValid = false;
				}
			}
			if(isValid) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		System.out.println(sb);
	}
}
