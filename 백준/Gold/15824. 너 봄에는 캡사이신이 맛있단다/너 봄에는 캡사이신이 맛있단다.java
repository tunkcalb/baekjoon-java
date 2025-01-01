import java.io.*;
import java.util.*;

public class Main {
	
	static int mod = 1000000007;
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		long ans = 0;
		for(int i = 0; i < N; i++) {
			ans += nums[i] * pow(2, i);
			ans -= nums[i] * pow(2, N - i - 1);
			ans %= mod;
		}
		System.out.println(ans);
	}

	private static long pow(int base, int x) {
		if(x == 0) return 1;
		long half = pow(base, x / 2);
		if(x % 2 == 0) return half * half % mod;
		return half * half * base % mod;
	}
}
