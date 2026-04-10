import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String num = br.readLine();
			
			if(num.equals("0")) break;
			
			while(num.length() >= 2) {
				int len = num.length();
				
				int sum = 0;
				for(int i = 0; i < len; i++) {
					sum += num.charAt(i) - '0';
				}
				
				num = String.valueOf(sum);
			}
			
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
	}
}
