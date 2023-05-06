import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		long[] nums = new long[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		long max = 0;
		
		if(N % 2 == 1) {
			for(int i = 0; i < N / 2; i++) {
				if(max < nums[i] + nums[N - 2 - i]) {
					max = nums[i] + nums[N - 2 - i];
				}
			}
			if(max < nums[N - 1]) max = nums[N - 1];
		}
		else {
			for(int i = 0; i < N / 2; i++) {
				if(max < nums[i] + nums[N - 1 - i]) {
					max = nums[i] + nums[N - 1 - i];
				}
			}
		}
		
		System.out.println(max);
	}
	
}