import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int max;
	static int[] nums;
	static int[] comb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = 3;
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		for(int i = N - 1; i > 1; i--) {
			if(nums[i - 1] + nums[i - 2] > nums[i]) {
				System.out.println(nums[i] + nums[i - 1] + nums[i - 2]);
				return;
			}
		}
		System.out.println(-1);
	}
}
