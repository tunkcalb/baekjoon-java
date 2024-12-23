import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Point[] points = new Point[N + 1];
		
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(in.readLine());
			points[i] = new Point(num, i);
		}
		
		Arrays.sort(points, 1, N + 1);
		
		int max = 0;
		for(int i = 1; i<= N; i++) {
			max = Math.max(max, points[i].idx - i);
		}
		System.out.println(max + 1);
	}
	
	static class Point implements Comparable<Point>{
		int num;
		int idx;
		
		Point(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Point o) {
			return num - o.num;
		}
	}
}
