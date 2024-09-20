import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int bot = 1;
		int top = nums[M - 1];
		int ans = 0;
		while(bot <= top) {
			int mid = (bot + top) / 2;
			int sum = 0;
			for(int num : nums) {
				sum += num / mid;
			}
			
			if(sum >= N) {
				bot = mid + 1;
				ans = mid;
			}
			else top = mid - 1;
			
		}
		System.out.println(ans);
	}
}
