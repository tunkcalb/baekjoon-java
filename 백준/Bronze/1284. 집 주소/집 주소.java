import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String line = br.readLine();
			if(line.equals("0")) break;
			
			int len = line.length();
			int sum = 1;
			
			for(int i = 0; i < len; i++) {
				char now = line.charAt(i);
				
				if(now == '0') sum += 5;
				else if (now == '1') sum += 3;
				else sum += 4;
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
