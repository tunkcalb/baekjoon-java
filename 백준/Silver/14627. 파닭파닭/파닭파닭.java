import java.io.*;
import java.util.*;

public class Main {
	
	static int S, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long[] nums = new long[S];
		long bot = 1;
		long top = 0;
		for(int i = 0; i < S; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			top = Math.max(top, nums[i]);
		}
		
		long len = top;
		while(bot <= top) {
			long mid = (bot + top) / 2;
			long sum = 0;
			
			for(long num : nums) {
				sum += num / mid;
			}
			
			if(sum >= C) {
				len = mid;
				bot = mid + 1;
			} else {
				top = mid - 1;
			}	
		}
		
		long sum = 0;
		for(long num : nums) {
			sum += num;
		}
		sum -= C * len;
		System.out.println(sum);
	}
}
