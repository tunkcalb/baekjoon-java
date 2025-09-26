import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int n = 13;
		int m = 26;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < line.length(); i++) {
			char now = line.charAt(i);
			
			if('a' <= now && now <= 'z') {
				now -= 'a';
				now += n;
				now %= m;
				now += 'a';
				now = (char) now;
			}
			if('A' <= now && now <= 'Z') {
				now -= 'A';
				now += n;
				now %= m;
				now += 'A';
				now = (char) now;
			}
			
			sb.append(now);
		}
		
		System.out.println(sb);
	}
}
