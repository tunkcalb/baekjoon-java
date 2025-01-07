import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Ball[] balls = new Ball[N];
		int[] colors = new int[N + 1];
		int[] results = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			balls[i] = new Ball(i, color, size);
		}
		
		Arrays.sort(balls);
		
		int sum = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			Ball ball = balls[i];
			while(balls[idx].size < ball.size) {
				sum += balls[idx].size;
				colors[balls[idx].color] += balls[idx].size;
				idx++;
			}
			results[ball.idx] = sum - colors[ball.color]; 
		}
		
		StringBuilder sb = new StringBuilder();
		for(int result : results) {
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	} 
	
	static class Ball implements Comparable<Ball>{
		int idx;
		int color;
		int size;
		
		Ball(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
		
		@Override
		public int compareTo(Ball o) {
			return this.size - o.size;
		}
	}
}
