import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int idx = 0;
		int sum = 0;
		for(int i = 0; i < line.length(); i++) {
			char now = line.charAt(i);
			
			if(now != '*') {
				sum += i % 2 == 0 ? now - '0' : (now - '0') * 3;
			}
			else idx = i;
		}
		
		int ans = 0;
		while(true) {
			if(idx % 2 == 0) {
				if((sum + ans) % 10 == 0) {
					System.out.println(ans);
					break;
				}
			}
			else {
				if((sum + (ans * 3)) % 10 == 0) {
					System.out.println(ans);
					break;
				}
			}
			ans++;
		}
		
	}
}
