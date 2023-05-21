import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		
		int num;
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(in.readLine());
			if(num == 0) {
				if(pq.isEmpty()) sb.append("0 \n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}
}
