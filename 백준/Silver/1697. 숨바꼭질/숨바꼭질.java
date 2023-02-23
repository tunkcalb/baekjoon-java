import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int maxstep;
	private static int[] cnt;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		maxstep = 100001;
		cnt = new int[maxstep];
		if(N >= K) System.out.println(N - K);
		else System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(N);
		cnt[N] = 1;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i = 0; i < 3; i++) {
				int next;
				
				if(i == 0) next = now - 1;
				else if (i == 1) next = now + 1;
				else next = now * 2;
				
				if(next == K) return cnt[now];
				
				if( 0 <= next && next <= 100000) {
					if(cnt[next] == 0) {
						queue.offer(next);
						cnt[next] = cnt[now] + 1;
					}
					
				}
				
			}
			
		}
		return 0;
	}
}