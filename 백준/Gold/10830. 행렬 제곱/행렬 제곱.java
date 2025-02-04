import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = 1000;
		long B = Long.parseLong(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ans = dfs(B);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] dfs(long b) {
		if(b == 1) {
			int[][] copy = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					copy[i][j] = board[i][j] % M;
				}
			}
			return copy;
		}
		
		int[][] half = dfs(b / 2);
		int[][] copy = multiply(half, half);
		if(b % 2 == 0) {
			return copy;
		}
		else {
			return multiply(copy, board);
		}
	}
	
	private static int[][] multiply(int[][] A, int[][] B) {
		int[][] result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += A[i][k] * B[k][j];
					result[i][j] %= M;
				}
			}
		}
		return result;
	}
}
