import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = 0;
		for(int i = 1; i <= K; i++) {
			int num = N * i;
			
			StringBuilder sb = new StringBuilder();
			
			int reverse = Integer.parseInt(sb.append(num).reverse().toString());
			
			max = Math.max(max, reverse);
		}
		
		System.out.println(max);
	}
}
