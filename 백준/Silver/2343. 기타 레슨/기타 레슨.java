import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(in.readLine());
		int bot = 0;
		int top = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			top += nums[i];
			bot = Math.max(bot, nums[i]);
		}
		
		int ans = 0;
		while(bot <= top) {
			int mid = (bot + top) / 2;
			
			int cnt = getCnt(mid);
			
			if(cnt > M) bot = mid + 1;
			else {
				top = mid - 1;
				ans = mid;
			}
		}
		
		System.out.println(ans);
	}

	private static int getCnt(int mid) {
		int cnt = 0;
		int sum = 0;
		
		for(int num : nums) {
			if(sum + num > mid) {
				sum = 0;
				cnt++;
			}
			sum += num;
		}
		if(sum != 0) cnt++;
		return cnt;
	}
}
