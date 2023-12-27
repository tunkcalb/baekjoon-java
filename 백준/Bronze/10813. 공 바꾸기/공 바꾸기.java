import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = i;
		}
		
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(in.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}
}
