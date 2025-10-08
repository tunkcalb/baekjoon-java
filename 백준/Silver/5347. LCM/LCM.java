import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(a < b) {
				long tmp = a;
				a = b;
				b = tmp;
			}
			
			long num = gcd(a, b);
			sb.append((a / num) * (b / num) * num).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long gcd(long a, long b) {
	    if (b == 0) return a;
	    return gcd(b, a % b);
	}
}
