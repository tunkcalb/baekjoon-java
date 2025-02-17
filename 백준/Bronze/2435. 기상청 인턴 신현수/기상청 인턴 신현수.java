import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			sum += nums[i];
		}
		
		int max = sum;
		for(int i = 0; i < N - K; i++) {
			sum -= nums[i];
			sum += nums[i + K];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
