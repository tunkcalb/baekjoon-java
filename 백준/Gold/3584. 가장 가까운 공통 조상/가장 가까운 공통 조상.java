import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			
			int[] parent = new int[N + 1];
			boolean[] visited = new boolean[N + 1];
			int a = 0;
			int b = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if(i == N - 1) {
					a = A;
					b = B;
				}
				else parent[B] = A;
			}
			
			int now = a;
			while(now != 0) {
				visited[now] = true;
				now = parent[now];
			}
			
			now = b;
			while(!visited[now]) {
				now = parent[now];
			}
			sb.append(now).append("\n");
		}
		System.out.println(sb);
	}
}
