import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int d = gcd(a, b);
			
			sb.append(a * b / d).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		
		while(b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}
}
