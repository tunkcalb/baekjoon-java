import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int L, P;
	static int ans;
	static int[][] oil;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		oil = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			oil[i][0] = Integer.parseInt(st.nextToken());
			oil[i][1] = Integer.parseInt(st.nextToken());
		}

		StringTokenizer st = new StringTokenizer(in.readLine());

		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				 return o2 - o1;
			}
		});

		int idx = 0;
		ans = 0;
		Arrays.sort(oil, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		while (P < L) {			
			while(idx < N && oil[idx][0] <= P) {
				pq.offer(oil[idx++][1]);
			}
			
			if(pq.isEmpty()) {
				ans = -1;
				break;
			}
			
			P += pq.poll();
			ans++;	
		}
		
		System.out.println(ans);
	}
}
