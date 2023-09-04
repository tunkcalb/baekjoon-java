import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] pre = new int[N + 1];
		
		List<Integer>[] list = new List[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			pre[B]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(pre[i] == 0) q.offer(i);
		}
		
		int[] ans = new int[N + 1];
		int time = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int num = q.poll();
				ans[num] = time;
				for(int idx : list[num]) {
					pre[idx]--;
					if(pre[idx] == 0) {
						q.offer(idx);
					}
				}
			}
			time++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}
}
