import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long[] fibo = new long[10000001];
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i  = 2; i <= N; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000007;
		}
		
		System.out.println(fibo[N]);
		
	}
}
