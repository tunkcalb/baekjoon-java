import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int cnt = 0;
		int start = 0;
		int end = N - 1;
		
		while(start < end) {
			if(nums[start] + nums[end] < M) {
				start++;
			} else if (nums[start] + nums[end] > M) {
				end--;
			} else {
				cnt++;
				start++;
				end--;
			}
		}
		System.out.println(cnt);
	}
}
