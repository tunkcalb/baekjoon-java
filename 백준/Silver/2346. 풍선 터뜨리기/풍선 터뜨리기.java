import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int idx;
		int num;
		
		public Point(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
	}
	
	static int N;
	static Deque<Point> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			q.add(new Point(i, Integer.parseInt(st.nextToken())));
		}
		
		start();
		System.out.println(sb);
	}

	private static void start() {
	
		Point now = q.poll();
		int num = now.num;
		int idx = now.idx;
		sb.append(idx + " ");
		while(!q.isEmpty()) {
			if(num > 0) {
				for(int i = 1; i < num; i++) {
					q.add(q.poll());
				}
				
				now = q.poll();
				num = now.num;
				idx = now.idx;
				sb.append(idx + " ");
			}
			else {
				for(int i = 1; i <= -num; i++) {
					q.addFirst(q.pollLast());
				}
				
				now = q.poll();
				num = now.num;
				idx = now.idx;
				sb.append(idx + " ");
			}
		}
		
	}
}
