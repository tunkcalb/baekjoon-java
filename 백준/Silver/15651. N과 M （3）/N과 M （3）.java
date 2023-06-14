import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			nums[cnt] = i;
			permutation(cnt + 1);
		}
	}
}
