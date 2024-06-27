import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) {
				sb.append("*");
			}
			
			for(int j = 0; j < (N - i) * 2; j++) {
				sb.append(" ");
			}
			
			for(int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i = N - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				sb.append("*");
			}
			
			for(int j = 0; j < (N - i) * 2; j++) {
				sb.append(" ");
			}
			
			for(int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
