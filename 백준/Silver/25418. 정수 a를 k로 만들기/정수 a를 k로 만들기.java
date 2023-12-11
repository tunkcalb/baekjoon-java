import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int N = 1000000;
		int[] nums = new int[N + 1];
		Arrays.fill(nums, N + 1);
		nums[A] = 0;
		for(int i = A; i <= N; i++) {
			if(i + 1 <= N && nums[i + 1] > nums[i] + 1) {
				nums[i + 1] = nums[i] + 1;
			}
			if(2 * i <= N && nums[2 * i] > nums[i] + 1) {
				nums[2 * i] = nums[i]  + 1;
			}
		}
		
		System.out.println(nums[K]);
	}
}
