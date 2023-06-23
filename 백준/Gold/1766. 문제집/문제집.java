import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] problem = new int[N + 1];
		
		ArrayList<ArrayList<Integer>> advance = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			advance.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			
			advance.get(first).add(last);
			problem[last]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			if (problem[i] == 0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");
			
			for(int next : advance.get(now)) {
				problem[next]--;
				
				if(problem[next] == 0) {
					pq.offer(next);
				}
			}
		}
		System.out.println(sb);
	}
}
