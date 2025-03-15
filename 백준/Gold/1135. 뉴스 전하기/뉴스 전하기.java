import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N];
		tree = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
		
		for(int i = 1; i< N; i++) {
			tree[nums[i]].add(i);
		}
		
		System.out.println(dfs(0));
	}

	private static int dfs(int now) {
		int cnt = 0;
		int max = 0;
		
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		for(Integer next : tree[now]) {
			dp[next] = dfs(next);
			q.add(new int[] {next, dp[next]});
		}
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			cnt++;
			max = Math.max(max, node[1] + cnt);
		}
		return max;
	}
	
}
