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
		
		Arrays.sort(nums);
		
		int max = 0;
		
		for(int i = 1; i < n - 1; i++) {
			
            int val1 = Math.abs(nums[0] + nums[i+1] - 2 * nums[i]);
            
            int val2 = Math.abs(nums[i-1] + nums[n-1] - 2 * nums[i]);
            
            max = Math.max(max, Math.max(val1, val2));
        }
		
		System.out.println(max);
	}
}
