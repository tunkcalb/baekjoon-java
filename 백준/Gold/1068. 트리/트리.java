import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int root = -1;
		
		for(int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			
			if(node == -1) {
				root = i;
				continue;
			}
			tree.get(node).add(i);
		}
		
		int rm = Integer.parseInt(br.readLine());
		
		if(rm == root) ans = 0;
		else dfs(rm, root);
		System.out.println(ans);
	}

	private static void dfs(int rm, int now) {
		if(tree.get(now).contains(rm)) {
			tree.get(now).remove(Integer.valueOf(rm));
		}
		
		if(tree.get(now).isEmpty()) {
			ans++;
			return;
		}
		
		for(int next : tree.get(now)) {
			dfs(rm, next);
		}
	}
}
