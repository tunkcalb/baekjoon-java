import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int s = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int sum = s;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				sum += q * p;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
