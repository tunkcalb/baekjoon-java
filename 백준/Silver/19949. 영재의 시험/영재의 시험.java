import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int[] tmp;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = 10;
		nums = new int[N];
		tmp = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		dfs(0);
		System.out.println(cnt);
	}

	private static void dfs(int depth) {
		if(depth == N) {
			int count = 0;
			for(int i = 0; i < N; i++) {
				if(nums[i] == tmp[i]) {
					count++;
				}
				
				if(count == 5) {
					cnt++;
					return;
				}
			}
			return;
		}
		
		for(int i = 1; i <= 5; i++) {
			if(depth > 1) {
				if(tmp[depth - 1] == i && tmp[depth  - 2] == i) {
					continue;
				}
			}
			tmp[depth] = i;
			dfs(depth + 1);
		}		
	}
}
