import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> high = new PriorityQueue<>();
		PriorityQueue<Integer> low = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			if(i % 2 == 1) {
				high.offer(Integer.parseInt(in.readLine()));
			}
			else 
				low.offer(-Integer.parseInt(in.readLine()));
			
			if(!low.isEmpty()) {
				if(high.peek() < -low.peek()) {
					int newhigh = -low.poll();
					int newlow = -high.poll();
					
					high.offer(newhigh);
					low.offer(newlow);
				}
			}
			
			if(i % 2 == 1) {
				sb.append(high.peek()).append("\n");
			}else
				sb.append(-low.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
