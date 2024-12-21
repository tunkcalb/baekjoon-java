import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			nums[i] = num;
			max = Math.max(max, num);
		}

		long bot = 1;
		long top = max;

		long ans = 0;
		while (bot <= top) {
			long mid = (bot + top) / 2;

			int sum = 0;
			for (int num : nums) {
				sum += num / mid;
			}
			if (sum < K) top = mid - 1;
			else {
				bot = mid + 1;
				ans = mid;
			}
		}
		System.out.println(ans);

	}
}
