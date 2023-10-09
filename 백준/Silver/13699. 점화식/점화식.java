import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long[] nums = new long[36];
		
		nums[0] = 1;
		nums[1] = 1;
		for(int i = 2; i < 36; i++) {
			for(int j = 0; j < i; j++) {
				nums[i] += (nums[j] * nums[i - 1 - j]);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append(nums[N]);
		System.out.println(sb);
	}
}
