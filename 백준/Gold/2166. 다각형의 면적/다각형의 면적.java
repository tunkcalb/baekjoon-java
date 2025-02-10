import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] x = new long[N + 1];
		long[] y = new long[N + 1];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		x[N] = x[0];
		y[N] = y[0];
		
		long a = 0;
		long b = 0;
		
		for(int i = 0; i < N; i++) {
			a += x[i] * y[i + 1];
			b += y[i] * x[i + 1];
		}
		
		String ans = String.format("%.1f", Math.abs(a - b) / 2.0);
		
		System.out.println(ans);
	}
}
