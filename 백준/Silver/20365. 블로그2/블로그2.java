import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		int b = 0;
		int r = 0;
		
		char color = '0';
		
		for(int i = 0; i < N; i++) {
			char now = line.charAt(i);
			if(now != color) {
				if(now == 'R') r++;
				else b++;
			}
			color = now;
		}
		
		System.out.println(Math.min(r,  b) + 1);
	}
}
