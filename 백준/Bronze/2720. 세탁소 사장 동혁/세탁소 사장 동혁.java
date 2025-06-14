import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int C = Integer.parseInt(br.readLine());
			
			int quater = C / 25;
			C %= 25;
			
			int dime = C / 10;
			C %= 10;
			
			int nickel = C / 5;
			C %= 5;
			
			int penny = C;
			
			sb.append(quater).append(" ").append(dime).append(" ").append(nickel).append(" ").append(penny);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
