import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			nums[i] = Integer.parseInt(in.readLine());
			sum += nums[i];
		}
		
		
		Arrays.sort(nums);
		System.out.println(sum/5);
		System.out.println(nums[2]);
	}
}
