import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int cnt = 1;
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		int max = nums[0];
		for(int i = 1; i < N; i++) {
			if(max < nums[i]) {
				max = nums[i];
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		
		cnt = 1;
		max = nums[N - 1];
		for(int i = N - 2; i >= 0; i--) {
			if(max < nums[i]) {
				max = nums[i];
				cnt++;
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}
