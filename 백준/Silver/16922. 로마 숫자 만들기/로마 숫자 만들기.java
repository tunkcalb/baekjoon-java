import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums = {1, 5, 10, 50};
	static Set<Integer> set;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		set = new HashSet<>();
		combination(0, 0, 0);
		
		System.out.println(set.size());
	}

	private static void combination(int idx, int depth, int sum) {
		if(depth == N) {
			set.add(sum);
			return;
		}
		
		for(int i = idx; i < 4; i++) {
			combination(i, depth + 1, sum + nums[i]);
		}
	}
}
