import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			int bot = 0;
			int top = N - 1;
			
			while(true) {
				if(bot == i) bot++;
				else if(top == i) top--;
				
				if(bot >= top) break;
				
				if(nums[bot] + nums[top] > nums[i]) top--;
				else if(nums[bot] + nums[top] < nums[i]) bot++;
				else {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
