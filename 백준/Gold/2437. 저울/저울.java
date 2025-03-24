import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int sum = 0;
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int num = nums[i];
			if(sum + 1 < num) {
				ans = sum + 1;
				break;
			}
			else {
				sum += num;
				ans = sum + 1;
			}
		}
		System.out.println(ans);
	}
}
