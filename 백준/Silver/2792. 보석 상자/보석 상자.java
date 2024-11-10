import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[M];
		
		int bot = 1;
		int top = 0;
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(in.readLine());
			top = Math.max(top, nums[i]);
		}
		
		int ans = 0;
		while(bot <= top) {
			int sum = 0;
			
			int mid = (bot + top) / 2;
			for(int num : nums) {
				if(num % mid == 0) {
					sum += num / mid;
				}
				else sum += num / mid + 1;
			}
			
			if(sum > N) {
				bot = mid + 1;
			}
			else {
				top = mid - 1;
				ans = mid;
			}
		}
		System.out.println(ans);
	}
}
