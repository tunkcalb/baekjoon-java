import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int len = line.length();
		int[] nums = new int[len];
		int[] cnt = new int[2];
		
		for(int i = 0; i < len; i++) {
			nums[i] = line.charAt(i) - '0';
			cnt[nums[i]]++;
		}
		
		cnt[0] /= 2;
		cnt[1] /= 2;
		
		for(int i = 0; i < len; i++) {
			if(cnt[1] == 0) break;
			if(nums[i] == 1) {
				nums[i] = -1;
				cnt[1]--;
			}
		}
		
		for(int i = len - 1; i >= 0; i--) {
			if(cnt[0] == 0) break;
			if(nums[i] == 0) {
				nums[i] = -1;
				cnt[0]--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++) {
			if(nums[i] == -1) continue;
			sb.append(nums[i]);
		}
		
		System.out.println(sb);
	}
}
