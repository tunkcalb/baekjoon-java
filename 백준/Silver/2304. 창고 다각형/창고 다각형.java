import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = 1000;
		int[] board = new int[M + 1];
		
		int max = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			board[L] = H;
			
			if(max < board[L]) {
				max = board[L];
				idx = L;
			}
		}
		
		int h = 0;
		int sum = 0;
		for(int i = 0; i < M; i++) {
			if(i == idx) break;
			if(h < board[i]) h = board[i];
			sum += h;
		}
		
		sum += max;
		
		h = 0;
		for(int i = M; i >= 0; i--) {
			if(i == idx) break;
			if(h < board[i]) h = board[i];
			sum += h;
		}
		
		System.out.println(sum);
	}
}
