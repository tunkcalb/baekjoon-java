import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		if(nums[2] - nums[1] == nums[1] - nums[0]) {
			System.out.println(nums[n - 1] + (nums[1] - nums[0]));
		}
		else {
			System.out.println(nums[n - 1] * (nums[1] / nums[0]));
		}
	}
}
