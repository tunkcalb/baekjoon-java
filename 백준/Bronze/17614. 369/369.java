import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			String s = Integer.toString(i);
			
			for(int j = 0; j < s.length(); j++) {
				char n = s.charAt(j);
				if(n == '3' || n == '6' || n == '9') {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
