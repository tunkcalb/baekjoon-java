import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			int sum = 0;
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 == 1) continue;
				
				min = Math.min(min, num);
				sum += num;
			}
			
			sb.append(sum).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}
}
