import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while(true) {
			idx++;
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) break;
			
			if(num % 2 == 0) {
				sb.append(idx).append(". ").append("even ").append(num / 2);
			}
			else {
				sb.append(idx).append(". ").append("odd ").append(num / 2);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
