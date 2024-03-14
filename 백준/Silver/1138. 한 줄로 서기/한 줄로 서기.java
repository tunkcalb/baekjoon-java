import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = N; i >= 1; i--) {
			list.add(nums[i], i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i));
			if(i != N) sb.append(" ");
		}
		System.out.println(sb);
	}
}
