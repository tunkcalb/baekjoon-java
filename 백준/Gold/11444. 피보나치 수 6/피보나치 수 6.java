import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static long[][] origin = {{1, 1}, {1, 0}};
	static long MOD = 1000000007;

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long[][] A = {{1, 1}, {1, 0}};
		
		long N = Long.parseLong(in.readLine());
		
		System.out.println(fibo(A, N - 1)[0][0]);
	}

	private static long[][] fibo(long[][] A, long exp) {
		
		if(exp == 1 || exp == 0) {
			return A;
		}
		
		
		long[][] ret = fibo(A, exp / 2);
		
		ret = multiply(ret, ret);
		
		if(exp % 2 == 1) {
			ret = multiply(ret, origin);
		}
		return ret;
	}

	private static long[][] multiply(long[][] A1, long[][] A2) {
		long[][] ret = new long[2][2];
		
		for(int k = 0; k < 2; k++) {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					ret[i][j] += A1[i][k] *  A2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
}
