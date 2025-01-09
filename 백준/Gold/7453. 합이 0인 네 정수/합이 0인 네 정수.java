import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = 4;
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] AB = new int[n * n];
		int[] CD = new int[n * n];
		
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int start = 0;
		int end = n * n - 1;
		
		long cnt = 0;
		while(start < n * n && end >= 0) {
			int num = AB[start] + CD[end];
			if(num < 0) start++;
			else if(num > 0) end--;
			else {
				long left = 1;
				long right = 1;
				while(start + 1 < n * n && AB[start] == AB[start + 1]) {
					left++;
					start++;
				}
				while(end > 0 && CD[end] == CD[end - 1]) {
					right++;
					end--;
				}
				cnt += left * right;
				start++;
				end--;
			}
		}
		System.out.println(cnt);
	}
}
