import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N + 1];
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				if(nums[i - 1] > 0) {
					nums[i] = nums[i - 1] + 1;
				}
				else nums[i] = 1;
			}
			sum += nums[i];
		}
		System.out.println(sum);
 	}
}
