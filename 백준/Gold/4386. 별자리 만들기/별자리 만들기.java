import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		Point[] points = new Point[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			
			points[i] = new Point(i, a, b);
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.weight - o2.weight));
		for(int i = 0; i < n - 1; i++) {
			Point start = points[i];
			for(int j = i + 1; j < n; j++) {
				Point end = points[j];
				double weight = Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
				pq.offer(new Edge(i, j, weight));
			}
		}
		
		parents = new int[n];
		
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		double sum = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int a = edge.start;
			int b = edge.end;
			double weight = edge.weight;
			if(find(a) == find(b)) continue;
			union(a, b);
			sum += weight;
		}
		System.out.println(sum);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		parents[b] = a;
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return find(parents[a]);
	}
	
	static class Point {
		int num;
		double x;
		double y;
		
		Point(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		int start;
		int end;
		double weight;
		
		Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}
