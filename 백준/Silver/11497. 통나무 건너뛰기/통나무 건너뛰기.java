import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] nums = new int [N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int[] arr = new int[N];
			int idx = 0;
			for(int i = 0; i < N; i++) {
				if(i % 2 == 1) continue;
				arr[idx++] = nums[i];
			}
			
			for(int i = N - 1; i > 0; i--) {
				if(i % 2 == 0) continue;
				arr[idx++] = nums[i];
			}
			
			int max = Math.abs(arr[0] - arr[N - 1]);
			for(int i = 0; i < N - 1; i++) {
				max = Math.max(max, Math.abs(arr[i] - arr[i + 1]));
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
