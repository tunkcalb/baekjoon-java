import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] nums = new long[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(nums);
		
		long min = Long.MAX_VALUE;
		long[] solution = new long[3];
		for(int i = 0; i < N - 2; i++) {
			int start = i;
			int mid = i + 1;
			int end = N - 1;
			
			while(mid < end) {
				long sum = nums[start] + nums[mid] + nums[end];
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					solution[0] = nums[start];
					solution[1] = nums[mid];
					solution[2] = nums[end];
				}
				if(sum == 0) break;
				else if(sum > 0) end--;
				else mid++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(solution[0]).append(" ");
		sb.append(solution[1]).append(" ");
		sb.append(solution[2]);
		System.out.println(sb);
	}
}
