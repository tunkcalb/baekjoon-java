import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(in.readLine(), ",");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= K; i++) {
			for(int j = 0; j < N - i; j++) {
				nums[j] = nums[j + 1] - nums[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N - K; i++) {
			sb.append(nums[i]);
			
			if(i != N - K - 1) {
				sb.append(",");
			}
		}
		System.out.println(sb);
	}
}
