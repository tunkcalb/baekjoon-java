import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		Integer[] kids = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			kids[i] = Integer.parseInt(st.nextToken());
		}
				
		for(int kid : kids) {
			int now = pq.poll();
			if(now < kid) {
				System.out.println(0);
				return;
			}
			pq.offer(now - kid);
		}
		System.out.println(1);
	}
}
