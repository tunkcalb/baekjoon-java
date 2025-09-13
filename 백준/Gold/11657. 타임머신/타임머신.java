import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(start, end, cost);
		}
		
		long[] dist = new long[N + 1];
		int max = Integer.MAX_VALUE;
		Arrays.fill(dist, max);
		
		dist[1] = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				Edge now = edges[j];
				
				if(dist[now.start] != max && dist[now.end] > dist[now.start] + now.cost) {
					dist[now.end]= dist[now.start]+ now.cost;  
				}
			}
		}
		
		boolean flag = false;
		
		for(int i = 0; i < M; i++) {
			Edge now = edges[i];
			
			if(dist[now.start] != max && dist[now.end] > dist[now.start] + now.cost) {
				flag = true;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(flag) {
			sb.append(-1);
		}
		else {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == max) sb.append(-1).append("\n");
				else sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static class Edge {
		int start;
		int end;
		int cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}
