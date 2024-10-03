import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static String ans;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		max = 0;
		ans = "";
		for(int i = N; i > 0; i--) {
			dfs(N, i, N + " " + i, 2);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(ans);
		System.out.println(sb);
	}
	
	static void dfs(int a, int b, String nums, int size) {
		if(b < 0) return;
		if(size > max) {
			max = size;
			ans = nums;
		}
		
		dfs(b, a - b, nums + " " + (a - b), size + 1);
	}
}
