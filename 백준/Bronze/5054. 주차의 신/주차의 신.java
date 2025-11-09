import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				min = Math.min(min, nums[i]);
				max = Math.max(max, nums[i]);
			}
			
			int avg = (nums[0] + nums[N - 1]) / 2;
			
			int sum = max - min;
			sum += (avg - min) + (max - avg);
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
