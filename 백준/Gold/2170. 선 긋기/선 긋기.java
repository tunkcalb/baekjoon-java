import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pq.offer(new Point(start, end));
		}
		Point now = pq.poll();
		
		int start = now.start;
		int end = now.end;
		
		int sum = 0;
		while(!pq.isEmpty()) {
			now = pq.poll();
			if(end > now.start) {
				if(end < now.end) end = now.end;
			}
			else {
				sum += end - start;
				start = now.start;
				end = now.end;
			}
		}
		sum += end - start;
		
		System.out.println(sum);
	}
	
	static class Point implements Comparable<Point>{
		int start;
		int end;
		
		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Point o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}
