import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(in.readLine());
		
		int[] nums = new int[L];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < L; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(in.readLine());
				
		Arrays.sort(nums);
		int start = 0;
		int end = 1001;
		
		for(int num : nums) {
			if(num < n) {
				if( num > start) {
					start = num;
				}
			}else if(num > n) {
				if(num < end) {
					end = num;
				}
			}else {
				System.out.println(0);
				return;
			}
		}
		
		int cnt = 0;
		
		for(int i = start + 1; i <= n; i++) {
			for(int j = n; j < end; j++) {
				if(i == j) continue;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
