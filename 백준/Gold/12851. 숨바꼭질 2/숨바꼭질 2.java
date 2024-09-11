import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		if(N >= K) {
			sb.append(N - K).append("\n").append(1);
			System.out.println(sb);
			return;
		}
		
		int ans = Integer.MAX_VALUE;
		int max = 1000000;
		int cnt = 0;
		int[] times = new int[max + 1];
		
		Queue<Integer> q = new LinkedList<>();
		times[N] = 1;
		q.offer(N);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(ans < times[now]) break;
			
			for(int i = 0; i < 3; i ++) {
				int next = 0;
				
				if(i == 0) next = now - 1;
				if(i == 1) next = now + 1;
				if(i == 2) next = now * 2;
				
				if(next < 0 || next > max) continue;
				
				if(next == K) {
					ans = times[now];
					cnt++;
				}
				
				if(times[next] == 0 || times[next] > times[now]) {
					q.offer(next);
					times[next] = times[now] + 1;
				}
			}
		}
		
		sb.append(ans).append("\n").append(cnt);
		System.out.println(sb);
	}
}
