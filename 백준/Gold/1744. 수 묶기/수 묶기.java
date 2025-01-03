import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num > 0) plus.offer(num);
			else minus.offer(num);
		}
		
		int sum = 0;
		while(!plus.isEmpty()) {
			if(plus.size() >= 2) {
				int a = plus.poll();
				int b = plus.poll();
				if(a * b > a + b) sum += a * b;
				else sum += a + b;
			}
			else {
				sum += plus.poll();
			}
		}
		
		while(!minus.isEmpty()) {
			if(minus.size() >= 2) {
				int a = minus.poll();
				int b = minus.poll();
				if(b != 0) sum += a * b;
			}
			else {
				sum += minus.poll();
			}
		}
		System.out.println(sum);
	}
}
