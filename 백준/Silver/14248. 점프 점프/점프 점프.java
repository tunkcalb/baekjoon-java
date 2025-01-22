import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int cnt;
	static int[] di = {-1, 1};
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n + 1];
		visited = new boolean[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = Integer.parseInt(br.readLine());
		
		visited[start] = true;
		cnt = 1;
		dfs(start);

		System.out.println(cnt);
	}

	private static void dfs(int now) {
		int gap = nums[now];
		
		for(int i = 0; i < 2; i++) {
			int next = now + di[i] * gap;
			
			if(next < 1 || next > n || visited[next]) continue;
			
			visited[next] = true;
			cnt++;
			dfs(next);
		}
	}
}
