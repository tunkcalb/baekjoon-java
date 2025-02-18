import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = 5;
		int[] nums = new int[N];
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			set.add(nums[i]);
		}
		
		Arrays.sort(nums);
		
		int max = 1;
		for(int num : nums) {
			int cnt = 1;
			for(int i = 1; i < M; i++) {
				if(set.contains(num + i)) cnt++;
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max <= M ? M - max : 0);
	}
}
