import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int N;
	static int K;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
		
	    nums = new int[N];
	    st = new StringTokenizer(in.readLine());
	    for(int i = 0; i < N; i++) {
	    	nums[i] = Integer.parseInt(st.nextToken());
	    }
		
	    cnt = 0;
	    dfs(0, 0);
	    if(K == 0) cnt--;
	    System.out.println(cnt);
	}

	private static void dfs(int idx, int sum) {
		if(idx == N) {
			if(sum == K) cnt++;
			return;
		}
		
		dfs(idx + 1, sum + nums[idx]);
		dfs(idx + 1, sum);
	}
}
