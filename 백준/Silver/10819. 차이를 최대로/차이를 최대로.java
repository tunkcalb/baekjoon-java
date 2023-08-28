import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int max;
	static int[] nums;
	static int[] ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		nums = new int[N];
		ans = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0);
		System.out.println(max);
	}

	private static void combination(int cnt) {
		if(cnt == N) {
			int sum = 0;
			
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs(ans[i] - ans[i + 1]);
			}
			max = Math.max(max, sum);
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ans[cnt] = nums[i];
			combination(cnt + 1);
			visited[i] = false;
		}
	}
}
