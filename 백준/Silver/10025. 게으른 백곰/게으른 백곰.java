import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) * 2 + 1;
		int M = 1000000;
		
		int[] ice = new int[M + 1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
		
			ice[x] = g;
		}
		
		int sum = 0;
		int max = 0;
		
		for(int i = 0; i <= M; i++) {
			if(i - K >= 0) sum -= ice[i - K];
			sum += ice[i];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
