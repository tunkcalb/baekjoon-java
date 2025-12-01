import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int C = Integer.parseInt(br.readLine());
		
		long sum = 0;
		
		for(int i = 0; i < N; i++) {
			if(nums[i] % C == 0) {
				sum += (nums[i] / C) * C;
			}
			else {
				sum += (nums[i] / C + 1) * C;
			}
		}
		
		System.out.println(sum);
	}
}
