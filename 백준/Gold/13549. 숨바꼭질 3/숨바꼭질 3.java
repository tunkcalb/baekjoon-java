import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int min = Integer.MAX_VALUE;
	static int max = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bfs(N, K);
		System.out.println(min);
		
	}

	private static void bfs(int n, int k) {
		boolean[] visited = new boolean[max + 1];
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(n, 0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int idx = now.idx;
			int time = now.time;
			visited[idx] = true;
			
			if(idx == k) {
				min = Math.min(min, time);
			}
			
			if(idx * 2 <= max && visited[idx * 2] == false) {
				q.offer(new Point(idx * 2, time));
			}
			if(idx - 1 >= 0 && visited[idx - 1] == false) {
				q.offer(new Point(idx - 1, time + 1));
			}
			if(idx + 1 <= max && visited[idx + 1] == false) {
				q.offer(new Point(idx + 1, time + 1));
			}
		}
		
	}
	
	public static class Point{
		int idx;
		int time;
		
		Point(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}
}
