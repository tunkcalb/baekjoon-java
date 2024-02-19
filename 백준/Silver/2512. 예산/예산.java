import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[N];
		
		int top = 0;
		int bottom = 1;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			top = Math.max(top,nums[i]);
		}
		
		int budget = Integer.parseInt(in.readLine());
		
		while(bottom <= top) {
			int mid = (bottom + top) / 2;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(nums[i] < mid) sum += nums[i];
				else sum += mid;
			}
			if(budget < sum) top = mid - 1;
			else bottom = mid + 1;
		}
		
		System.out.println(top);
	}
}
