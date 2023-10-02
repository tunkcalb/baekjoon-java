import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long ans = A * B / gcd(A, B);
		
		System.out.println(ans);
		
	}

	private static long gcd(long a, long b) {
		while(b != 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
