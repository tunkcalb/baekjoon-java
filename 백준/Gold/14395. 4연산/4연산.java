import java.io.*;
import java.util.*;

public class Main {
	
	static int s;
	static int t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		if(s == t) {
			System.out.println(0);
			return;
		}
		if(t == 0) {
			System.out.println("-");
			return;
		}
		if(t == 1) {
			System.out.println("/");
			return;
		}
		
		bfs();
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(s, ""));
		HashSet<Long> set = new HashSet<>();
		set.add((long) s);
		
		String[] oper = {"*", "+", "-", "/"};
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			long num = now.num;
			String cal = now.cal;
			if(num == t) {
				System.out.println(cal);
				return;
			}
			if(num > 1e9) continue;
			long next = num;
			for(int i = 0; i < 4; i++) {
				switch(i) {
					case 0:
						next = num * num;
						break;
					case 1:
						next = num + num;
						break;
					case 2:
						next = 0;
						break;
					case 3:
						if(num == 0) break;
						next = 1;
						break;
				}
				if(!set.contains(next)) {
					set.add(next);
					q.offer(new Point(next, cal + oper[i]));
				}
			}
		}
		System.out.println(-1);
	}
	
	static class Point {
		long num;
		String cal;
		
		Point(long num, String cal) {
			this.num = num;
			this.cal = cal;
		}
	}
}
