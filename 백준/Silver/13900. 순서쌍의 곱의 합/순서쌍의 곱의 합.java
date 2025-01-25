import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] nums = new long[N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
		}
		
		long ans = 0;
		
		for(int i = 0; i < N; i++) {
			long num = sum - nums[i];
			ans += num * nums[i];
		}
		System.out.println(ans / 2);
	}
}
