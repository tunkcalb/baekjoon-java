import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = K - 1;
		
		st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			sum += nums[i];
		}
		int max = sum;
		
		for(int i = K - 1; i < N - 1; i++) {
			sum -= nums[start];
			
			start++;
			end++;
			sum += nums[end];
			
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
