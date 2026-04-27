import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			String a = br.readLine();
			String b = br.readLine();
			
			int len = a.length();
			int cnt = 0;
			
			for(int i = 0; i < len; i++) {
				if(a.charAt(i) != b.charAt(i)) cnt++;
			}
			
			sb.append("Hamming distance is ").append(cnt).append(".\n");
		}
		
		System.out.println(sb);
	}
}
