import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int k = 1; k <= K; k++) {
			sb.append("Class ").append(k).append("\n");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int gap = 0;
			for(int i = 1; i < N; i++) {
				gap = Math.max(gap, nums[i] - nums[i - 1]);
			}
			
			sb.append("Max ").append(nums[N - 1]).append(", Min ").append(nums[0]);
			sb.append(", Largest gap ").append(gap).append("\n");
			
		}
		
		System.out.println(sb);
	}
}
