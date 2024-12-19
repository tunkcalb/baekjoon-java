import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				set.add(nums[i] + nums[j]);
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = nums[i] - nums[j];
				if(num <= 0) continue;
				if(set.contains(num)) {
					max = Math.max(max, nums[i]);
				}
			}
		}
		System.out.println(max);
	}
}
