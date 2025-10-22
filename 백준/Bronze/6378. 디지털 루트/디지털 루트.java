import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String S = br.readLine();
			
			if(S.equals("0")) break;
			
			while(true) {
				int sum = 0;
				
				if(S.length() < 2) {
					break;
				}
				else {
					for(int i = 0; i < S.length(); i++) {
						sum += S.charAt(i) - '0';
					}
				}
				
				S = String.valueOf(sum);
			}
			sb.append(S).append("\n");
		}
		
		System.out.println(sb);
	}
}
