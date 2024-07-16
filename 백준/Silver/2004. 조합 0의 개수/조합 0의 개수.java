import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		int five = 5;
		int two = 2;
		long cnt5 = power(N, five) - power(N - M, five) - power(M, five);
		long cnt2 = power(N, two) - power(N - M, two) - power(M, two);
		System.out.println(Math.min(cnt5, cnt2));
	}

	private static int power(long m, int num) {
		int cnt = 0;
		
		while (m >= num) {
			cnt += (m / num);
			m /= num;
		}
		return cnt;
	}
}
