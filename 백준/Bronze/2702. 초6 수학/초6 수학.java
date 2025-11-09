import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int num = gcd(a, b);
			
			sb.append((a / num) * (b / num) * num).append(" ").append(num).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(b == 0) return a;
		
		a %= b;
		int tmp = a;
		a = b;
		b = tmp;
		
		return gcd(a, b);
	}
}
