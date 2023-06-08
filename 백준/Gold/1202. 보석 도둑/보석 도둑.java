import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Jewelry> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Jewelry(m, v));
		}
		Collections.sort(list, (o1, o2) -> o1.m - o2.m);
		
		int[] weight = new int[K];
		
		for(int i = 0; i < K; i++) {
			weight[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(weight);
		
		long total = 0;
		int idx = 0;
		PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		
		for(int i = 0; i < K; i++) {
			while(idx < N && list.get(idx).m <= weight[i]) {
				Jewelry now = list.get(idx++);
				pq.add(now);
			}
			if(!pq.isEmpty()) total += pq.poll().v;
		}
		System.out.println(total);
	}
	
	
	static class Jewelry{
		int m;
		int v;
		
		public Jewelry(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}
	}
}
