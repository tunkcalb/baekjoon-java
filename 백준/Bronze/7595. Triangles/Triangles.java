import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			sb.append(star(N));
		}
		
		System.out.println(sb);
	}

	private static Object star(int n) {

		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
