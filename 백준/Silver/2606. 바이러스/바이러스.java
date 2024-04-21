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
		
		int N = Integer.parseInt(in.readLine());
		
		int M = Integer.parseInt(in.readLine());
		boolean[] visited = new boolean[N + 1];
		List<Integer>[] list = new List[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			Integer now = q.poll();
			
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					cnt++;
					q.offer(next);
				}
			}
		}
		System.out.println(cnt);
	}
}
