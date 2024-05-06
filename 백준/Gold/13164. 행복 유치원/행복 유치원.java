import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i < N; i++) {
			list.add(nums[i] - nums[i - 1]);
		}
		Collections.sort(list);
		
		int sum = 0;
		for(int i = 0; i < N - K; i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}
}
