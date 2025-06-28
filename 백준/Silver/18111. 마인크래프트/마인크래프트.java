import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, B;
	static int min, max;
	static int ans, height;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		max = 0;
		min = 256;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				board[i][j] = h;
				min = Math.min(h,  min);
				max = Math.max(h,  max);
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int i = max; i >= min; i--) cal(i);
		
		System.out.println(ans + " " + height);
	}

	private static void cal(int h) {
		int time = 0;
		int b = B;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(time > ans) return;
				
				if(board[i][j] > h) {
					int sub = board[i][j] - h;
					time += 2 * sub;
					b += sub;
				} else if(board[i][j] < h) {
					int sub = h - board[i][j];
					time += sub;
					b -= sub;
				}
			}
		}
		
		if(b >= 0 && ans > time) {
			ans = time;
			height = h;
		}
	}
}
