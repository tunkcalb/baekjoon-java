import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String num = in.readLine();
		int cnt = 0;
		while(num.length() > 1) {
			int sum = 0;
			
			for(int i = 0; i < num.length(); i++) {
				sum += num.charAt(i) - '0';
			}
			
			num = String.valueOf(sum);
			cnt++;
		}
		
		System.out.println(cnt);
		
		if(Integer.parseInt(num) % 3 == 0) System.out.println("YES");
		else System.out.println("NO");
	}
}
