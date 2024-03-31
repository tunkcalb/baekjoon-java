import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String S = in.readLine();
		
		int zero = 0;
		int one = 0;
		
		int length = S.length();
		
		for(int i = 0; i < length; i++) {
			if(i == 0) {
				if(S.charAt(i) == '0') zero++;
				else one++;
			}
			else if(S.charAt(i - 1) != S.charAt(i)) {
				if(S.charAt(i) == '0') zero++;
				else one++;
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
