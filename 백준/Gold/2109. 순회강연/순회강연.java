import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = 10000;
		List<Point> list = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Point(p, d));
		}
		
		Collections.sort(list, (o1, o2) -> (o1.p == o2.p) ? o2.d - o1.d : o2.p - o1.p);
		
		boolean[] days = new boolean[m + 1];
		int sum = 0;
		for(Point day : list) {
			for(int i = day.d; i >= 1; i--) {
				if(days[i]) continue;
				days[i] = true;
				sum += day.p;
				break;
			}
		}
		
		System.out.println(sum);
	}
	
	static class Point {
		int p;
		int d;
		
		Point(int p, int d) {
			this.p = p;
			this.d = d;
		}
	}
}
