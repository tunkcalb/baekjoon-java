import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		nums = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int bot = 0;
		int top = N;
		int ans = N;
		while(bot <= top) {
			int mid = (bot + top) / 2;
			
			if(possible(mid)) {
				ans = mid;
				top = mid - 1;
			}
			else bot = mid + 1;
			
		}
		System.out.println(ans);
	}
	
	static boolean possible(int target) {
        int prev = 0;

        for(int num : nums) {
            if(num - target <= prev) {
                prev = num + target;
            } else { return false; }
        }

        return N - prev <= 0;
    }
}
