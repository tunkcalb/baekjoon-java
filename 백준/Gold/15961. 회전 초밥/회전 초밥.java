import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[d + 1];
		int[] belt = new int[N];
		for(int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		}
		
		int start = 0;
		int cnt = 0;
		for(int i = 0; i < k; i++) {
			int add = belt[i];
			if(nums[add] == 0) cnt++;
			nums[add]++;
		}
		int max = cnt + (nums[c] > 0 ? 0 : 1);

		for(int i = 0; i < N; i++) {
			int remove = belt[i];
			nums[remove]--;
			if(nums[remove] == 0) cnt--;
			
			int add = belt[(i + k) % N];
			nums[add]++;
			if(nums[add] == 1) cnt++;
			
			max = Math.max(max, cnt + (nums[c] > 0 ? 0 : 1));
		}
		System.out.println(max);
	}
}
