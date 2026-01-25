import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int M = 5;
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[M];
			
			
			for(int i = 0; i < M; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			if(nums[M - 2] - nums[1] >= 4) {
				sb.append("KIN");
			}
			else {
				int sum = 0;
				for(int i = 1; i < M - 1; i++) {
					sum += nums[i];
				}
				sb.append(sum);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
