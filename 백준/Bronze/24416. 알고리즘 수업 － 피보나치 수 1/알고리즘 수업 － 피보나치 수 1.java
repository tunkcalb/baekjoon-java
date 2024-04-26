import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int dp = 0;
		
		if(N == 1 || N == 2) dp = 1;
		else dp = N - 2;
		cnt = 0;
		fibo(N);
		
		System.out.println(cnt + " " + dp);
	}

	private static int fibo(int n) {
		if(n == 1 || n == 2) {
			cnt++;
			return 1;
		}
		
		return fibo(n - 1) + fibo(n - 2);
	}
}
