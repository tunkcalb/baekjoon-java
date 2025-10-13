import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 10;
		
		int[] aNums = new int[N];
		int[] bNums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			aNums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			bNums[i] = Integer.parseInt(st.nextToken());
		}
		
		int A = 0;
		int B = 0;
		String winner = "D";
		for(int i = 0; i < N; i++) {
			int a = aNums[i];
			int b = bNums[i];
			if(a < b) {
				B += 3;
				winner = "B";
			}
			if(a > b) {
				A += 3;
				winner = "A";
			}
			if(a == b) {
				A++;
				B++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(A).append(" ").append(B).append("\n");
		
		if(A > B) sb.append("A");
		if(A < B) sb.append("B");
		if(A == B) sb.append(winner);
		
		System.out.println(sb);
	}
}
