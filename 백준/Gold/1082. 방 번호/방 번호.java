import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int minIdx = N;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(min > nums[i]) {
				min = nums[i];
				minIdx = i;
			}
		}

		M = Integer.parseInt(br.readLine());
		if(min > M) {
			System.out.println(0);
			return;
		}
		
		
		int minLen = M / min;
		
		if(minLen == 0) {
			System.out.println(0);
			return;
		}
		
		int[] ans = new int[minLen];
		Arrays.fill(ans, min);
		
		int remain = M - min * minLen;
		int start = 0;
		for(int i = 0; i < minLen; i++) {
			for(int j = N - 1; j >= 0; j--) {
				int cost = nums[j];
				int diff = cost - min;
				
				if(remain >= diff) {
					ans[i] = j;
					remain -= diff;
					break;
				}
			}
			
			if(ans[start] == 0) {
				start++;
				remain += min;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = start; i < minLen; i++) {
			sb.append(ans[i]);
		}
		if(start == minLen) {
			sb.append(0);
		}
		System.out.println(sb);
	}
}
