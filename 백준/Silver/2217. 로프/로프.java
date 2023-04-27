import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Integer[] nums = new Integer[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(nums, Collections.reverseOrder());
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			int now = (i + 1) * nums[i];
			if(max < now) max = now;
		}
		
		System.out.println(max);
	}
}
