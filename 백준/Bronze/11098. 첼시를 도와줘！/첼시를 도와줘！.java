import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < n; t++) {
			
			int p = Integer.parseInt(br.readLine());
			
			int max = 0;
			String ans = "";
			for(int i = 0; i < p; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int C = Integer.parseInt(st.nextToken());
				String a = st.nextToken();
				
				if(max < C) {
					max = C;
					ans = a;
				}
			}
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
