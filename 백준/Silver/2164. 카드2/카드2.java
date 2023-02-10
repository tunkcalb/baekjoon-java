import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(in.readLine());
		for (int i = N; i >= 1; i--) {
			queue.offer(i);
		}
		while(queue.size() != 1) {
			queue.pollLast();
			int num = queue.pollLast();
			queue.offerFirst(num);
		}
		System.out.println(queue.poll());
	}
}