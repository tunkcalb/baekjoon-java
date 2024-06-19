import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		int[] W = new int[N];
		int[] K = new int[N];
		
		for(int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(in.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			K[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(W);
		Arrays.sort(K);
		
		System.out.print(W[N - 1] + W[N - 2] + W[N - 3]);
		System.out.print(" ");
		System.out.print(K[N - 1] + K[N - 2] + K[N - 3]);
		
	}
}
