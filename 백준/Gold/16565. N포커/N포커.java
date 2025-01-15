import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int all = 52;
	static int mod = 10007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = all / 4;
		long ans = 0;
		for(int i = 1; i <= N / 4; i++) {
			ans += combination(all - i * 4, N - i * 4) * combination(M, i) * Math.pow(-1, i - 1);
			ans %= mod;
			ans = (ans + mod) % mod;
		}
		System.out.println(ans);
	}

	private static long combination(int n, int k) {
		long a = 1;
		long b = 1;
		
		for(int i = 0; i < k; i++) {
			a *= n - i;
			a %= mod;
			b *= i + 1;
			b %= mod;
		}
		return div(a, b) % mod;
	}

	private static long div(long x, long y) {
		return (x * pow(y, mod - 2)) % mod;
	}

	private static long pow(long x, long n) {
		if(n == 1) return x % mod;
		
		long half = pow(x, n / 2);
		if(n % 2 == 0) return (half * half) % mod;
		else return ((half * half) % mod * x) % mod;
	}
}
