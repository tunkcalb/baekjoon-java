import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		boolean[] nums = new boolean[10000001];
		
		for(int i =2; i <= Math.sqrt(nums.length); i++) {
			if(nums[i]) continue;
			
			for(int j = i * 2; j< nums.length; j += i) {
				nums[j] = true;
			}
		}
		
		int cnt = 0;
		
		for(int i = 2; i < nums.length; i++) {
			if(nums[i]) continue;
			long now = i;
			long p = now * now;
			while(p <= B) {
				if(p >= A) {
					cnt++;
				}
				
				if(p > B / now) break;
				p *= now;
			}
		}
		System.out.println(cnt);
	}
}
