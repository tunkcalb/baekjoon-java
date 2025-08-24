import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static char[] nums;
	static List<String> ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = 10;
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new char[M];
		
		for(int i = 0; i < N; i++) {
			nums[i] = st.nextToken().charAt(0);
		}
		
		ans = new ArrayList<>();
		visited = new boolean[M];
		
		dfs("", 0);
		
		Collections.sort(ans);
		
		System.out.println(ans.get(ans.size() - 1));
		System.out.println(ans.get(0));
	}

	private static void dfs(String num, int idx) {
		
		if(idx == N + 1) {
			ans.add(num);
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(visited[i]) continue;
			if(idx == 0 || check(Character.getNumericValue(num.charAt(idx - 1)), i, nums[idx - 1])) {
				visited[i] = true;
				dfs(num + i, idx + 1);
				visited[i] = false;
			}
		}
	}


	private static boolean check(int a, int b, char c) {
		
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
	}
}
