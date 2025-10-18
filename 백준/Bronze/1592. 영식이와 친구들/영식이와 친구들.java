import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n + 1];
		int num = 1;
		int cnt = 0;
		
		while(true) {
			nums[num]++;
			
			if(nums[num] == m) break;
			
			if(nums[num] % 2 == 1) {
				num += l;
				if(num > n) {
					num -= n;
				}
			}
			else {
				num -= l;
				if(num <= 0) {
					num += n;
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
