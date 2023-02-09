import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[] prime = {2, 3, 5, 7};

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		/**
		 * 3. 알고리즘 풀기
		 */
		
		for (int i = 0; i < prime.length; i++) {
			appendNumber(prime[i]);
		}

		/**
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}

	private static void appendNumber(int num) {
		if (String.valueOf(num).length() == N) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i < 10; i += 2) {
			int testNum = num * 10 + i;
			if (isPrime(testNum)) {
				appendNumber(testNum);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}