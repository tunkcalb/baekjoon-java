import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		bfs();
		
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(0, N, N + " "));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int cnt = now.cnt;
			int n = now.n;
			String line = now.line;			
			if(n == 1) {
				sb.append(cnt).append("\n");
				sb.append(line);
				return;
			}
			
			if(n % 3 == 0) {
				q.offer(new Point(cnt + 1, n / 3, line + n / 3 + " "));
			}
			if(n % 2 == 0) {
				q.offer(new Point(cnt + 1, n / 2, line + n / 2 + " "));
			}
			q.offer(new Point(cnt + 1, n - 1, line + (n - 1) + " "));
		}
	}
	
	static class Point{
		int cnt;
		int n;
		String line;
		
		public Point(int cnt, int n, String line) {
			super();
			this.cnt = cnt;
			this.n = n;
			this.line = line;
		}

	}
}
