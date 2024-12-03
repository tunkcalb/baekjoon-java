import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0) minus.offer(num);
			else plus.offer(num);
		}
		int max = 0;
		int sum = 0;
		while(!minus.isEmpty()) {
			int distance = (-1) * minus.peek();
			max = Math.max(max, distance);
			sum += distance * 2;
			
			for(int i = 0; i < M; i++) {
				if(minus.isEmpty()) break;
				minus.poll();
			}
		}
		
		while(!plus.isEmpty()) {
			int distance = plus.peek();
			max = Math.max(max, distance);
			sum += distance * 2;
	
			for(int i = 0; i < M; i++) {
				if(plus.isEmpty()) break;
				plus.poll();
			}
		}
		sum -= max;
		System.out.println(sum);
	}
}
