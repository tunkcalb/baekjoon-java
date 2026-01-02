import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Integer[] cost = new Integer[M];
		for(int i = 0; i < M; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(cost, Collections.reverseOrder());
		
		int price = 0;
		int max = 0;
		int size = Math.min(M, N);
		
		for(int i = 0; i < size; i++) {
			int tmp = (i + 1) * cost[i];
			
			if(max < tmp) {
				max = tmp;
				price = cost[i];
			}
		}
		
		System.out.println(price + " " + max);
	}
}
