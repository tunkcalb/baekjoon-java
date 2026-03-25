import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			br.readLine();
			
			int N = Integer.parseInt(br.readLine());
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				sum += Long.parseLong(br.readLine());
				sum %= N;
			}
			
			if(sum % N == 0) {
				sb.append("YES");
			}
			else sb.append("NO");
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
