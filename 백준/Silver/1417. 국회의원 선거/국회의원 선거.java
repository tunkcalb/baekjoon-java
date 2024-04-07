import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int a = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());		
		
		for(int i = 0; i < n - 1; i++) {
			pq.offer(Integer.parseInt(in.readLine()));
		}
		int cnt = 0;
		while(!pq.isEmpty() && pq.peek() >= a) {
			cnt++;
			a++;
			pq.offer(pq.poll() - 1);
		}
		System.out.println(cnt);
	}
}
