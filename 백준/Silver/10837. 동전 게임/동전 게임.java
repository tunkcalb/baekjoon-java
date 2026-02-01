import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m < n) {
				if(n - m - 1 >= k - n + 1) sb.append(0);
				else sb.append(1);
			}
			else if (m > n) {
				if(m - n - 1 > k - m + 1) sb.append(0);
				else sb.append(1);
			}
			else sb.append(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
