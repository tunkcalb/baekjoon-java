import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N + 1];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int idx = i; idx <= j; idx++) {
				nums[idx] = k;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}
}
