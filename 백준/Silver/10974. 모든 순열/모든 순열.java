import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] nums;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		nums = new int[N];
		isSelected = new boolean[N + 1];
		
		permutation(0);
		
		System.out.println(sb);
	}

	private static void permutation(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			nums[idx] = i;
			isSelected[i] = true;
			permutation(idx + 1);
			isSelected[i] = false;
		}
		
	}
}
