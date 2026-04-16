import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long[] nums = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		long max = 0;
		
		for(int i = 1; i < N; i++) {
			long sum = (N - i) * nums[i] + i * nums[0];
			
			max = Math.max(max, sum);
		}
		
		long ans = K / max + (K % max == 0 ? 0 : 1);
		
		System.out.println(ans);
	}
}
