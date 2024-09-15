import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) {
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.poll()).append("\n");
				}
			}
			else {
				for(int j = 0; j < num; j++) {
					q.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}
}
