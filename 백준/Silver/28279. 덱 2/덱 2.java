import java.io.*;
import java.util.*;

public class Main {
	
	static Deque<Integer> deque;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		deque = new LinkedList<>();
		sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command =  Integer.parseInt(st.nextToken());
			int x;
			switch(command) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				deque.addFirst(x);
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				deque.addLast(x);
				break;
			case 3:
				if(isEmpty()) break;
				sb.append(deque.pollFirst()).append("\n");
				break;
			case 4:
				if(isEmpty()) break;
				sb.append(deque.pollLast()).append("\n");
				break;
			case 5:
				sb.append(deque.size()).append("\n");
				break;
			case 6:
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case 7:
				if(isEmpty()) break;
				sb.append(deque.peekFirst()).append("\n");
				break;
			case 8:
				if(isEmpty()) break;
				sb.append(deque.peekLast()).append("\n");
				break;
			}			
		}
		System.out.println(sb);
	}
	private static boolean isEmpty() {
		if(deque.isEmpty()) {
			sb.append(-1).append("\n");
			return true;
		}
		return false;
	}
}
