import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = 5;
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			boolean flag = true;
			
			for(int i = 0; i < N - 1; i++) {
				if(nums[i] > nums[i + 1]) {
					int temp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = temp;
					print(nums);
					flag = false;
				}
			}
			if(flag) break;
		}
		
		System.out.println(sb);
	}

	private static void print(int[] nums) {
		for(int i = 0; i < N; i++) {
			sb.append(nums[i]);
			if(i == N - 1) sb.append("\n");
			else sb.append(" ");
		}
	}
}
