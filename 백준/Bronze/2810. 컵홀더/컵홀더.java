import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		String line = in.readLine();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(line.charAt(i) == 'S') cnt++;
			else {
				cnt++;
				i++;
			}
		}
		cnt++;
		System.out.println(Math.min(cnt, n));
	}
}
