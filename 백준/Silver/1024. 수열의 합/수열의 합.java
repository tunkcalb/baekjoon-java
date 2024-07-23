import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		while(L <= 100) {
			int min = N / L - (L - 1) / 2;
			if(min < 0) break;
			
			if(N == (min * 2 + L - 1) * L / 2) {
				for(int i = 0; i < L; i++) {
					sb.append(min + i + " ");
				}
				System.out.println(sb);
				System.exit(0);
			}
			L++;
		}
		System.out.println(-1);
	}
}
