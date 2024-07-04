import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(nums);
		
		int i = 0;
		int j = 0;
		
		int ans = Integer.MAX_VALUE;
		while(j < N) {
			if(nums[j] - nums[i] < M) {
				j++;
				continue;
			}
			
			if(nums[j] - nums[i] == M) {
				ans = M;
				break;
			}
			ans = Math.min(ans, nums[j] - nums[i]);
			i++;
		}
		
		System.out.println(ans);
	}
}
