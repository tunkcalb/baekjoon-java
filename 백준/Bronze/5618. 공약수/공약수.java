import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, nums[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		mod: for(int i = 1; i <= min; i++) {
			for(int j = 0; j < n; j++) {
				if(nums[j] % i != 0) continue mod;
			}
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
