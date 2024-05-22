import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = 5;
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 1;
		while(true) {
			int cnt = 0;
			for(int num : nums) {
				if(ans % num == 0) cnt++;
			}
			if(cnt >= 3) break;
			ans++;
		}
		System.out.println(ans);
	}
}
