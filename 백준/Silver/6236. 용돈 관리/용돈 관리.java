import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		int bot = 0;
		int top = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
			bot = Math.max(nums[i], bot);
			top += nums[i];
		}
		
		int mid = 0;
		int ans = 0;
		while(bot <= top) {
			mid = (top + bot) / 2;
			int money = 0;
			int cnt = 0;
			for(int num : nums) {
				if(money >= num) {
					money -= num;
				}
				else {
					money = mid;
					money -= num;
					cnt++;
				}
			}
			
			if(cnt <= M) {
				top = mid - 1;
				ans = mid;
			}
			else {
				bot = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
