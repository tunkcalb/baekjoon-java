import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		long[] nums = new long[N + 1];
		long[] cnt = new long[M];
		long ans = 0;
		for(int i = 1; i <= N; i++) {
			nums[i] = (nums[i - 1] + Integer.parseInt(st.nextToken())) % M;
			
			if(nums[i] == 0) ans++;
			
			cnt[(int) nums[i]]++;
		}
		
		for(int i = 0; i < M; i++) {
			if(cnt[i] > 1) ans += cnt[i] *(cnt[i] - 1) / 2;
		}
		System.out.println(ans);
	}
}
