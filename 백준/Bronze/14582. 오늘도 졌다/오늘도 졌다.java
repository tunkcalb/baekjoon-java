import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 9;
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = 0;
		String ans = "No";
		for(int i = 0; i < N; i++) {
			a += A[i];
			
			if(a > b) {
				ans = "Yes";
				break;
			}
			
			b += B[i];
		}
		
		System.out.println(ans);
	}
}
