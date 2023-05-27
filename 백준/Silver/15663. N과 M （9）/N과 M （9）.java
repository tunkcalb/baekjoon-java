import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums, perm;
	static boolean[] visited;
	static LinkedHashSet<String> ans = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		perm = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		Arrays.sort(nums);
		permutation(0);
		
		Iterator<String> iter = ans.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	private static void permutation(int cnt) {
		
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int num : perm) {
				sb.append(num).append(" ");
			}
			ans.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm[cnt] = nums[i];
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
