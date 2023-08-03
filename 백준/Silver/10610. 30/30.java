import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = in.readLine();
		int N = line.length();
		boolean zero = false;
		Integer[] nums = new Integer[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = line.charAt(i) - '0';
			if (num == 0) zero = true;
			sum += num;
			nums[i] = num;
		}

		if (sum % 3 != 0 || !zero) {
			System.out.println(-1);
		} else {
			Arrays.sort(nums, Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				sb.append(nums[i]);
			}
			System.out.println(sb);
		}
	}
}
