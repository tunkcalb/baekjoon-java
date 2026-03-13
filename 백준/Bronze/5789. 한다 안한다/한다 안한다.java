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
			
			if(line.charAt(len / 2 - 1) == line.charAt(len / 2)) {
				sb.append("Do-it");
			}
			else sb.append("Do-it-Not");
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
