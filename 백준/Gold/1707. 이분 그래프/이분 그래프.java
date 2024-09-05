import java.io.*;
import java.util.*;

public class Main {
	
	static int[] check;
	static List<List<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		
		time: for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			check = new int[V + 1];
			for(int i = 0; i <= V; i++) {
				list.add(new ArrayList<>());
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			for(int i = 1; i <= V; i++) {
				if(check[i] == 0) {
					if(dfs(i, 1)) {
						System.out.println("NO");
						continue time;
					}
				}
			}
			System.out.println("YES");
		}
	}

	private static boolean dfs(int v, int group) {
		check[v] = group;
		
		for(int x : list.get(v)) {
			if(check[x] == group) return true;
			else if(check[x] == 0) {
				if(dfs(x, group * (-1))) {
					return true;
				}
			}

		}
		return false;
	}
}
