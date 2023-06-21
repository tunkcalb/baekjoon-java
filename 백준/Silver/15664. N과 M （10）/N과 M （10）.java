import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums;
	static int[] number;
	static HashSet<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		number = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		permutation(0, 0, " ");
		
		System.out.println(sb);
	}

	private static void permutation(int cnt, int start, String check) {
		if(cnt == M) {
			if(set.contains(check)) return;
			
			set.add(check);
			
			for(int i = 0; i < M; i++) {
				sb.append(number[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			number[cnt] = nums[i];
			permutation(cnt + 1, i + 1, check + nums[i] + " ");
		}
	}
}
