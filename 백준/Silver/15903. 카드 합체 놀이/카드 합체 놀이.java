import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		for(int i = 0; i < m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			long sum = a + b;
			pq.offer(sum);
			pq.offer(sum);
		}
		
		long sum = 0;
		
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}
}
