import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int N = A.length();
		int M = B.length();
		
		int[] a = new int[N];
		int[] b = new int[M];
		
		for(int i = 0; i < N; i++) {
			a[i] = A.charAt(i) - '0';
		}
		for(int i = 0; i < M; i++) {
			b[i] = B.charAt(i) - '0';
		}
		
		long sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sum += a[i] * b[j];
			}
		}
		System.out.println(sum);
	}
}
