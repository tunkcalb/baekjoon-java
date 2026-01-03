import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		while(true) {
			String cal = br.readLine();
			
			if(cal.equals("=")) break;
			
			if(cal.equals("+")) {
				num += Integer.parseInt(br.readLine());
			}
			else if(cal.equals("*")) {
				num *= Integer.parseInt(br.readLine());
			}
			else if(cal.equals("/")) {
				num /= Integer.parseInt(br.readLine());
			}
			else if(cal.equals("-")) {
				num -= Integer.parseInt(br.readLine());
			}
		}
		
		System.out.println(num);
	}
}
