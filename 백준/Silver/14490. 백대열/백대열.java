import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), ":");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(A, B);
		
		StringBuilder sb = new StringBuilder();
		sb.append(A / gcd).append(":").append(B / gcd);
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int temp = a;
		
		while(temp != 0) {
			temp = b % a;
			b = a;
			a = temp;
		}
		
		return b;
	}
}
