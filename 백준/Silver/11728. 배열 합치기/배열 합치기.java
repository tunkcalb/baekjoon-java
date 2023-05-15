import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < M; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N + M; i++) {
			sb.append(pq.poll()).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
