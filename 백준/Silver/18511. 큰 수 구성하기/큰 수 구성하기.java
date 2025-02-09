import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int ans;
	static Integer[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new Integer[K];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < K; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums, Collections.reverseOrder());
		
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int num) {
		if(num > N) return;
		
		if(ans < num) ans = num;
		
		for(int i = 0; i < K; i++) {
			dfs(num * 10 + nums[i]);
		}
	}
}
