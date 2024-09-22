import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		
		if(a < b) {
			long tmp = a;
			a = b;
			b= tmp;
		}
		
		long gcd = gcd(a, b);
		StringBuilder sb = new StringBuilder();
		
		for(long i = 0; i < gcd; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}
	
	static long gcd(long a, long b) {
		if(a % b == 0) return b;
		else if (b == 0) return a;
		else return gcd(b, a % b);
	}
}
