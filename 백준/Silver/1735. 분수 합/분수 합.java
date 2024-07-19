import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int A = a * d + b * c;
		int B = b * d;
		
		int mod = gcd(A, B);
		
		A /= mod;
		B /= mod;
		
		System.out.println(A + " " + B);
	}
	
	public static int gcd(int a, int b) {
		if(a <= b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}
}
