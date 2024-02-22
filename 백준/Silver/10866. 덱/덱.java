import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Deque<String> deque = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("push_front")) deque.offerFirst(st.nextToken());
			if(command.equals("push_back")) deque.offerLast(st.nextToken());
			if(command.equals("pop_front")) {
				if(deque.size() == 0) System.out.println(-1);
				else System.out.println(deque.pollFirst());
			}
			if(command.equals("pop_back")) {
				if(deque.size() == 0) System.out.println(-1);
				else System.out.println(deque.pollLast());
			}
			if(command.equals("size")) System.out.println(deque.size());
			if(command.equals("empty")) {
				if(deque.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			if(command.equals("front")) {
				if(deque.isEmpty()) System.out.println(-1);
				else System.out.println(deque.peekFirst());
			}
			if(command.equals("back")) {
				if(deque.isEmpty()) System.out.println(-1);
				else System.out.println(deque.peekLast());
			}
		}	
	}
}
