import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N];
		int[] rotate = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			basket[i] = i + 1;
		}
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int k = Integer.parseInt(st.nextToken()) - 1;
			int l = i;
			
			for(int b = 0; b < j - i + 1; b++) {
				if(k + b <= j) {
					rotate[b + i] = basket[k + b];
				} else {
					rotate[b + i] = basket[l++];
				}
			}
			
			for(int b = 0; b < N; b++) {
				if(rotate[b] != 0) {
					basket[b] = rotate[b];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(basket[i] + " ");
		}
		
		System.out.println(sb);
	}
}
