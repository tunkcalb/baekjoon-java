import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == -1) break;
			
			if(num == 0) q.poll();
			else {
				if(q.size() == N) continue;
				q.offer(num);
			}
		}
		
		int size = q.size();
		
		StringBuilder sb = new StringBuilder();
		if(size == 0) {
			sb.append("empty");
		}
		else {
			for(int i = 0; i < size; i++) {
				sb.append(q.poll()).append(" ");
			}
		}
		System.out.println(sb);
	}
}
