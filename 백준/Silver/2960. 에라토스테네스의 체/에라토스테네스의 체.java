import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = cal(N, K);
		System.out.println(ans);
	}

	private static int cal(int N, int K) {
		boolean[] nums = new boolean[N + 1];
		
		for(int i = 2; i <= N; i++) {
			nums[i] = true;
		}
		
		for(int i = 2; i <= N; i++) {
			if (!nums[i]) continue;
			
			for(int j = i; j <= N; j += i) {
				if(nums[j]) {
					nums[j] = false;
					K--;
					if(K == 0) {
						return j;
					}
				}
			}
		}
		return 0;
	}
}
