import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int d = Integer.parseInt(br.readLine());
			
			int max = 1;
			
			while(max + (max * max) <= d) {
				max++;
			}
			
			sb.append(max - 1).append("\n");
		}
		
		System.out.println(sb);
	}
}
