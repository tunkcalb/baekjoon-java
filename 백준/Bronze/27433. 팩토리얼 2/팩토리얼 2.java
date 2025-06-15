import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] nums = new long[20 + 1];
		
		nums[0] = 1;
		nums[1] = 1;
		
		for(int i = 2; i <= 20; i++) {
			nums[i] = nums[i - 1] * i;
		}
		
		System.out.println(nums[N]);
	}
}
