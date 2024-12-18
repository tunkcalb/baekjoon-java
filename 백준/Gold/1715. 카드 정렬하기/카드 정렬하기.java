import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(in.readLine()));
		}
		
		long sum = 0;
		while(pq.size() >= 2) {
			long a = pq.poll();
			long b = pq.poll();
			
			sum += a + b;
			
			pq.offer(a + b);
		}
		System.out.println(sum);
	}
}
