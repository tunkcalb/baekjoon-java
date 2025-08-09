import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 20;
		int M = 10;
		nums = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			while(start < end) {
				swap(start++, end--);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(nums[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	private static void swap(int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}
}
