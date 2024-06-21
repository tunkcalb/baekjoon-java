import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		int len = line.length();
		int ans = 1;
		
		StringBuilder sb = new StringBuilder(line);
		sb.reverse();
		
		for(int i = 0; i < len / 2; i++) {
			if(line.charAt(i) != sb.charAt(i)) {
				ans = 0;
			}
		}
		System.out.println(ans);
	}
}
