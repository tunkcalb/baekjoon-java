import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		
		if(K >= N) {
			System.out.println(0);
			return;
		}
		
		int[] censor = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			censor[i] = Integer.parseInt(st.nextToken());
		}
		
		Integer[] gap = new Integer[N - 1];
		Arrays.sort(censor);
		
		for(int i = 0; i < N - 1; i++) {
			gap[i] = censor[i + 1] - censor[i];
		}
		
		Arrays.sort(gap, Collections.reverseOrder());
		
		int sum = 0;
		
		for(int i = K -1; i < N - 1; i++) {
			sum += gap[i];
		}
		System.out.println(sum);
	}
}
