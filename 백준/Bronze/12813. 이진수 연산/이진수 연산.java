import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();
		
		int N = A.length();
		
		StringBuilder  sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(a & b);
		}
		sb.append("\n");
		
		for(int i = 0; i < N; i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(a | b);
		}
		sb.append("\n");
		
		for(int i = 0; i < N; i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(a ^ b);
		}
		sb.append("\n");
		
		for(int i = 0; i < N; i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(~a + 2);
		}
		sb.append("\n");
		
		for(int i = 0; i < N; i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(~b + 2);
		}
		sb.append("\n");
		
		System.out.println(sb);
	}
}
