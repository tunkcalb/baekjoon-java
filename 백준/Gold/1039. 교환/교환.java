import java.io.*;
import java.util.*;

public class Main {
	
	static int max;
	static int N, K;
	static int len;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		set = new HashSet<>();
		max = -1;
		bfs();
		System.out.println(max);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[1000001][K + 1];
		q.offer(new Point(N, 0));
		int len = String.valueOf(N).length();
		while(!q.isEmpty()) {
			Point now = q.poll();
			int num = now.num;
			int cnt = now.cnt;
			
			if(cnt == K) {
				max = Math.max(max, num);
				continue;
			}
			
			for(int i = 0; i < len - 1; i++) {
				for(int j = i + 1; j < len; j++) {
					int next = swap(num, i, j);
					if(next == -1 || visited[next][cnt + 1]) continue;
					q.offer(new Point(next, cnt + 1));
					visited[next][cnt + 1] = true;
				}
			}
			
		}
	}
	
	private static int swap(int num, int i, int j) {
		
		char[] nums = String.valueOf(num).toCharArray();
		
		char a = nums[i];
		char b = nums[j];
		if(i == 0 && nums[j] == '0') {
			return - 1;
		}
		nums[i] = b;
		nums[j] = a;
		return Integer.parseInt(new String(nums));
	}

	static class Point {
		int num;
		int cnt;
		
		Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
