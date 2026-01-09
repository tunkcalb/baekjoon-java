import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = 2 * N;
		int[] nums = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		int min = nums[M - 1] * 2;
		
		for(int i = 0; i < N; i++) {
			min = Math.min(min, nums[i] + nums[M - 1 - i]);
		}
		
		System.out.println(min);
	}
}
