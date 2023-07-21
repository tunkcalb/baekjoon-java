import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int max;
	static int[] num;
	static int[] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		num = new int[n];
		dp = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = num[0];
		visited[0] = true;
		max = num[0];
		func(n - 1);
		
		System.out.println(max);
	}

	private static int func(int N) {
		
		if(!visited[N]) {
			dp[N] = Math.max(func(N - 1) + num[N], num[N]);
			max = Math.max(dp[N], max);
			visited[N] = true;
		}
		
		return dp[N];
	}
}
