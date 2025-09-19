import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			
			String line = br.readLine();
			int len = line.length();
			
			int num = line.charAt(len - 1) - '0';
			if(num % 2 == 1) {
				sb.append("odd").append("\n");
			}
			else {
				sb.append("even").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
