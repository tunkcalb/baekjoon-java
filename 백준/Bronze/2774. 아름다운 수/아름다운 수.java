import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			Set<Character> set = new HashSet<>();
			String line = br.readLine();
			int len = line.length();
			
			for(int i = 0; i < len; i++) {
				set.add(line.charAt(i));
			}
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}
}
