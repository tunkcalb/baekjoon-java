import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int min = 1000000001 * 2;
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = N - 1;
		int a = left;
		int b = right;
		while(left < right) {
			int sum = nums[left] + nums[right];
			if(Math.abs(sum) < min) {
				a = nums[left];
				b = nums[right];
				min = Math.abs(sum);
				if(sum == 0) break;
			}
			if(sum < 0) left++;
			else right--;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(" ").append(b);
		
		System.out.println(sb);
	}
}
