import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		long[] nums = new long[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		boolean[] inf = new boolean[N];
		int cnt = 0;
		for(int i = 1; i < N; i++) {
			if(Math.abs(nums[i] - nums[i - 1]) < M && !inf[i - 1]) {
				inf[i] = true;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
