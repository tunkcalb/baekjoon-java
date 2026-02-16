import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int n = 3;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			sb.append("Scenario #").append(t).append(":").append("\n");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[n];
			for(int i = 0 ; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			long a = nums[0] * nums[0];
			long b = nums[1] * nums[1];
			long c = nums[2] * nums[2];
			
			if(c == a + b) {
				sb.append("yes");
			}
			else sb.append("no");
			
			sb.append("\n");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
