import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int[] cal;
	static int N, M;
	static int max, min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = 4;
		nums = new int[N];
		cal = new int[M];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < M; i ++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		max = -Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(nums[0], 1);
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n");
		sb.append(min);
		System.out.println(sb);
	}

	private static void dfs(int num, int idx) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i = 0; i < M; i++) {
			if(cal[i] == 0) continue;
			
			cal[i]--;
			
			switch(i) {
			case 0:
				dfs(num + nums[idx], idx + 1);
				break;
			case 1:
				dfs(num - nums[idx], idx + 1);
				break;
			case 2:
				dfs(num * nums[idx], idx + 1);
				break;
			case 3:
				dfs(num / nums[idx], idx + 1);
				break;
			}
			cal[i]++;
		}
	}
}
