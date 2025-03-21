import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int INF;
	static int[] nums;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N + 1];
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nums[i] = a;
			nums[i + 1] = b;
		}
		
		INF = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(board[i], INF);
		}
		 
		int ans = fill(0, N - 1);
		
		System.out.println(ans);
	}

	private static int fill(int left, int right) {
		if(left == right) return 0;
		if(board[left][right] != INF) return board[left][right];
		
		for(int i = left; i < right; i++) {
			int val = fill(left, i) + fill(i + 1, right) + (nums[left] * nums[i + 1] * nums[right + 1]);
			board[left][right] = Math.min(board[left][right], val);
		}
		
		return board[left][right];
	}
}
