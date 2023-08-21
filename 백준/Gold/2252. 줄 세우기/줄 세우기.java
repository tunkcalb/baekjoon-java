import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer>[] next = new List[N + 1];
		int[] count = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			next[i] = new ArrayList<>();
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			next[A].add(B);
			count[B]++;
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			if(count[i] == 0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			
			int num = q.poll();
			for(int idx : next[num]) {
				count[idx]--;
				if(count[idx] == 0) {
					q.offer(idx);
				}
			}
			
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);
	}
}
