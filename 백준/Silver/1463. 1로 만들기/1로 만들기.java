import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static class Point{
		int num;
		int cnt;
		
		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		visited = new boolean[N + 1];
		if(N == 1) {
			System.out.println(0);
		}else {
			cal();			
		}
	}

	private static void cal() {
		Queue<Point> q = new ArrayDeque<>();
		
		q.offer(new Point(N, 0));
		visited[N] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.num % 3 == 0) {
				if(!visited[now.num/3]) {
					if(now.num/3 == 1) {
						System.out.println(now.cnt + 1);
						return;
					}
					visited[now.num/3] = true;
					q.offer(new Point(now.num/3, now.cnt + 1));
				}
			}
			if(now.num % 2 == 0) {
				if(!visited[now.num/2]) {
					if(now.num/2 == 1) {
						System.out.println(now.cnt + 1);
						return;
					}
					visited[now.num/2] = true;
					q.offer(new Point(now.num/2, now.cnt + 1));
				}
			}
			if(!visited[now.num - 1]) {
				if(now.num - 1 == 1) {
					System.out.println(now.cnt + 1);
					return;
				}
				visited[now.num - 1] = true;
				q.offer(new Point(now.num - 1, now.cnt + 1));
			}
		}
	}
}