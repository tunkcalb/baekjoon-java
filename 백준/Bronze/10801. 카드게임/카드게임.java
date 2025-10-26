import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 10;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < N; i++) {
			if(A[i] > B[i]) a++;
			if(A[i] < B[i]) b++;
		}
		
		if(a == b) System.out.println("D");
		if(a > b) System.out.println("A");
		if(a < b) System.out.println("B");
		
	}
}
