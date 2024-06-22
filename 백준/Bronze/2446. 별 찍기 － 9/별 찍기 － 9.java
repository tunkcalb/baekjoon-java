import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = N; i > 0; i--) {
			for(int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			
			for(int j = 0; j < i * 2 - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			
			for(int j = 0; j < i * 2 - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
