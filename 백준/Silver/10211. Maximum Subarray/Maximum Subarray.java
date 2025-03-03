import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
			}
			int max = -1000;
			for(int i = 0; i <= N; i++) {
				for(int j = i + 1; j <= N; j++) {
					max = Math.max(max, nums[j] - nums[i]);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
