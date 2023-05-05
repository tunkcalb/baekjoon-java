import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Road implements Comparable<Road>{

		int end;
		long cost;
		int canCover;
		
		public Road(int end, long cost, int canCover) {
			super();
			this.end = end;
			this.cost = cost;
			this.canCover = canCover;
		}

		@Override
		public int compareTo(Road o) {
			return (int) (this.cost - o.cost);
		}
	}
	
	static int N, M, K;
	static ArrayList<Road>[] cities;
	static long[][] dijk;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cities = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			cities[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			cities[start].add(new Road(end, cost, 0));
			cities[end].add(new Road(start, cost, 0));
		}
		
		dijk = new long[N + 1][K + 1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dijk[i], Long.MAX_VALUE);
		}
		start();
	}

	private static void start() {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		pq.offer(new Road(1, 0, 0));
		dijk[1][0] = 0;
		
		while(!pq.isEmpty()) {
			Road road = pq.poll();
			int end = road.end;
			long cost = road.cost;
			int canCover = road.canCover;
			
			if(dijk[end][canCover] < cost) continue;
			
			for(Road now : cities[end]) {
				if(dijk[now.end][canCover] > cost + now.cost) {
					dijk[now.end][canCover] = cost + now.cost;
					pq.offer(new Road(now.end, dijk[now.end][canCover],canCover));
				}
				if(canCover < K && dijk[now.end][canCover + 1] > cost) {
					dijk[now.end][canCover + 1] = cost;
					pq.offer(new Road(now.end, dijk[now.end][canCover + 1], canCover + 1));
				}
			}
		}
		long result = Long.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			result = Math.min(dijk[N][i], result);
		}
		System.out.println(result);
	}
}
