import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int len = line.length();
		
		int[] nums = new int[len];
		
		for(int i = 0; i < len; i++) {
			nums[i] = line.charAt(i) - '0';
		}
		
		for(int i = len - 1; i > 0; i--) {
			if(nums[i] >= 5) {
				nums[i - 1]++;
			}
			nums[i] = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int num : nums) {
			sb.append(num);
		}
		
		System.out.println(sb);
	}
}
