import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		int red = 0;
		int blue = 0;
		
		for(int i = 0; i < N; i++) {
			if(line.charAt(i) == 'R') red++;
			else blue++;
		}
				
		char start = line.charAt(0);
		int cnt = 1;
		
		for(int i = 1; i < N; i++) {
			if(line.charAt(i) == start) cnt++;
			else break;
		}
		
		int ans = Integer.MAX_VALUE;
		if(start == 'R') {
			ans = Math.min(ans, Math.min(red - cnt, blue));
		}
		else {
			ans = Math.min(ans, Math.min(blue - cnt, red));
		}
		
		cnt = 1;
		start = line.charAt(N - 1);
		
		for(int i = N - 2; i >= 0; i--) {
			if(line.charAt(i) == start) cnt++;
			else break;
		}
		
		if(start == 'R') {
			ans = Math.min(ans, Math.min(red - cnt, blue));
		}
		else {
			ans = Math.min(ans, Math.min(blue - cnt, red));
		}
	
		System.out.println(ans);
	}
}
