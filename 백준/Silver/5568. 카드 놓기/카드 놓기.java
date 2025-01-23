import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	static int[] perm;
	static int[] nums;
	static boolean[] visited;
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		nums = new int[n];
		perm = new int[k];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		set = new HashSet<>();
		
		permutation(0);
		
		System.out.println(set.size());
	}

	private static void permutation(int cnt) {
		if(cnt == k) {
			StringBuilder sb = new StringBuilder();
			for(int num : perm) {
				sb.append(num);
			}
			set.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			perm[cnt] = nums[i];
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
