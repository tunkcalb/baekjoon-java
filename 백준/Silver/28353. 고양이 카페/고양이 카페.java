import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int start = 0;
		int end = N - 1;
		int cnt = 0;
		
		while(start < end) {
			if(nums[start] + nums[end] > K) {
				end--;
			}
			else {
				start++;
				end--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
