import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			String line = br.readLine();
			String reverse = "";
			
			for(int i = line.length() - 1; i >= 0; i--) {
				reverse += line.charAt(i);
			}
			
			int sum = Integer.parseInt(line) + Integer.parseInt(reverse);
			String num = Integer.toString(sum);
			
			boolean flag = true;
			for(int i = 0; i < (num.length() / 2); i++) {
				char left = num.charAt(i);
				char right = num.charAt(num.length() - i - 1);
				
				if(left != right) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append("YES").append("\n");
			}
			else {
				sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
