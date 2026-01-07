import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Task> stack = new Stack<>();
		int sum = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			if(type == 1) {
				int score = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				stack.push(new Task(score, t));
			}
			
			if(!stack.isEmpty()) {
				stack.peek().t--;
				if(stack.peek().t == 0) {
					sum += stack.pop().score;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	static class Task {
		int score;
		int t;
		
		Task(int score, int t) {
			this.score = score;
			this.t =  t;
		}
	}
}
