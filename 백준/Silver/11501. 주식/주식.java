import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			
			nums = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			int max = 0;
			for(int i = N - 1; i >= 0; i--) {
				if(max < nums[i]) {
					max = nums[i];
				} else {
					sum += (max - nums[i]);
				}
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
