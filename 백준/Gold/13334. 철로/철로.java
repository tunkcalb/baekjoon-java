import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		List<Rail> rails = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rails.add(new Rail(a, b));
		}
		
		Collections.sort(rails);
		int d = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = 0;
		for(Rail rail : rails) {
			int l = rail.left;
			int r = rail.right;
			
			if(r - l > d) continue;
			pq.offer(l);
			
			while(!pq.isEmpty()) {
				if(r - pq.peek() <= d) break;
				pq.poll();
			}
			ans = Math.max(ans, pq.size());
		}
		System.out.println(ans);
	}
	
	static class Rail implements Comparable<Rail>{
		int left;
		int right;
		
		Rail(int a, int b) {
			if(a < b) {
				this.left = a;
				this.right = b;				
			}
			else {
				this.left = b;
				this.right = a;
			}
		}
		
		@Override
		public int compareTo(Rail o) {
			if(o.right == right) {
				return left - o.left;
			}
			return right - o.right;
		}
	}
}
