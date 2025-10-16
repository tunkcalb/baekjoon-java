import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			
			if( i == 0) {
				nums[0] = M;
			}
			else {
				nums[i] = (M * (i + 1)) - sum;
			}
			
			sum += nums[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int k : nums) {
			sb.append(k).append(" ");
		}
		
		System.out.println(sb);
	}
}
