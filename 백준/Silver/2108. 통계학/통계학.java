import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += nums[i];
		}
		
		
		Arrays.sort(nums);
		
		int cnt = 0;
		int max = -1;
		
		int freq = nums[0];
		boolean flag = true;
		for(int i = 0; i < N - 1; i++) {
			if(nums[i] == nums[i + 1]) cnt++;
			else cnt = 0;
			
			if(max < cnt) {
				max = cnt;
				freq = nums[i];
				flag = true;
			}
			else if(max == cnt && flag == true) {
				freq = nums[i];
				flag = false;
			}
		}
		
		System.out.println(Math.round( sum / (float) N));
		System.out.println(nums[(N - 1) / 2]);
		System.out.println(freq);
		System.out.println(nums[N - 1] - nums[0]);
	}
}
