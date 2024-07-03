import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Integer[] A = new Integer[a];
			Integer[] B = new Integer[b];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < a; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < b; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A, Collections.reverseOrder());
			Arrays.sort(B, Collections.reverseOrder());
			
			int temp = 0;
			for(int aNum : A) {
				int cnt = 0;
				for(int bNum : B) {
					if(aNum > bNum) {
						temp += (b - cnt);
						break;
					}
					else cnt++;
				}
			}
			sb.append(temp).append("\n");
		}
		System.out.println(sb);
	}
}
