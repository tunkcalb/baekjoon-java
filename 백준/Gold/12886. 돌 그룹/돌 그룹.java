import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[1500 + 1][1500 + 1];
		
		if((A + B + C) % 3 != 0) {
			ans = 0;
		}
		else {
			dfs(A, B, C);
		}
		
		System.out.println(ans);
	}

	private static void dfs(int a, int b, int c) {
		if(a == b && b == c) {
			ans = 1;
			return;
		}

		check(a, b, c);
		check(b, c, a);
		check(c, a, b);
	}

	private static void check(int a, int b, int c) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		if(!visited[min+min][max-min]) {
			visited[min+min][max-min] = true;
			dfs(min+min, max-min, c);
		}
	}
}
