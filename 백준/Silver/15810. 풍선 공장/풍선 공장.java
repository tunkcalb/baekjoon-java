import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] times = new long[N];
		long min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, times[i]);
		}
		
		long left = 0;
		long right = min * M;
		
		long ans = 0;
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			
			for(int i = 0; i < N; i++) {
				cnt += mid / times[i];
			}
			
			if(cnt >= M) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
