import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];

		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;

		while (start <= N && end <= N) {
			if (sum >= S && min > end - start)
				min = end - start;
			if (sum < S)
				sum += nums[end++];
			else
				sum -= nums[start++];
		}

		if (min == Integer.MAX_VALUE)
			min = 0;
		System.out.println(min);
	}
}
