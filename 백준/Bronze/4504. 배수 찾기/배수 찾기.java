import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) break;
			
			if(num % N == 0) {
				sb.append(num).append(" is a multiple of ").append(N).append(".");
			}
			else {
				sb.append(num).append(" is NOT a multiple of ").append(N).append(".");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
