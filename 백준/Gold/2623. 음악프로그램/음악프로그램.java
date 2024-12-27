import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N + 1];
		List<Integer>[] list = new List[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int K = Integer.parseInt(st.nextToken());
			List<Integer> nums = new ArrayList<>();
			nums.add(Integer.parseInt(st.nextToken()));
			for(int k = 1; k < K; k++) {
				int next = Integer.parseInt(st.nextToken());
				for(int now : nums) {
					list[now].add(next);
					cnt[next]++;
				}
				nums.add(next);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(cnt[i] == 0) q.offer(i);
		}
		
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append("\n");
			count++;
			for(int next : list[now]) {
				cnt[next]--;
				if(cnt[next] == 0) q.offer(next);
			}
		}
		
		if(count == N) {
			System.out.println(sb);
		}
		else System.out.println(0);
	}
}
