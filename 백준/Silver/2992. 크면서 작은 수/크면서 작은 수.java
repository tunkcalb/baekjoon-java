import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		int N = line.length();
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = line.charAt(i) - '0';
		}
		
		boolean change = false;
		out: for(int i = N - 1; i > 0; i--) {
			if(nums[i] > nums[i - 1]) {
				int temp = nums[i - 1];
				for(int j = N - 1; j >= i; j--) {
					if(nums[j] > temp) {
						swap(nums, i - 1, j);
						change = true;
						int start = i;
						int end = N - 1;
						while(start < end) {
							swap(nums, start++, end--);
						}
						break out;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(change) {
			for(int num : nums) {
				sb.append(num);
			}
		}
		else {
			sb.append(0);
		}
		System.out.println(sb);
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
