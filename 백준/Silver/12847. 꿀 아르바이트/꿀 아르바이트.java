import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = M;
		
		long sum = 0;
		
		for(int i = 0; i < M; i++) {
			sum += nums[i];
		}
		
		long max = 0;
		while(end < N) {
			max = Math.max(max, sum);
			
			sum -= nums[start];
			sum += nums[end];
			start++;
			end++;
		}
		
		System.out.println(max);
	}
}
