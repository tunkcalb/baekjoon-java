import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dp = new int[101][101];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(check(N, M) < K) {
			System.out.println(-1);
		} else {
			make(N, M, K);
			System.out.println(sb);
		}
		
	}

	private static void make(int a, int z, int k) {
		if(a == 0) {
			for(int i = 0; i < z; i++) {
				sb.append("z");
			}
			return;
		}
		if(z == 0) {
			for(int i = 0; i < a; i++) {
				sb.append("a");
			}
			return;
		}
		
		int cnt = check(a - 1, z);
		if(k > cnt) {
			sb.append("z");
			make(a, z - 1, k - cnt);
		} else {
			sb.append("a");
			make(a - 1, z, k);
		}
	}

	private static int check(int a, int z) {
		if(a == 0 || z == 0) return 1;
		if(dp[a][z] != 0) return dp[a][z];
		return dp[a][z] = Math.min(check(a - 1, z) + check(a, z - 1), 1000000001);
	}
}
