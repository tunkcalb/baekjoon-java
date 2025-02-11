import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(br.readLine());
		
		int[] trees = new int[N];
		
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(br.readLine());
		}
		
		int gcd = 0;
		
		for(int i = 0; i < N - 1; i++) {
			int distance = trees[i + 1] - trees[i];
			gcd = findGCD(distance, gcd);
		}
		System.out.println((trees[N - 1] - trees[0]) / gcd + 1 - N);
	}

	private static int findGCD(int a, int b) {
		while(b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
