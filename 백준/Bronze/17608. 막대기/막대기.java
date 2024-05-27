import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		int top = 0;
		for(int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				stack.push(Integer.parseInt(in.readLine()));
				top = stack.peek();
			}
			else {
				int now = stack.peek();
				int next = Integer.parseInt(in.readLine());
				
				while(now <= next) {
					stack.pop();
					if(stack.isEmpty()) break;
					else now = stack.peek();
				}
				stack.push(next);
			}
		}
		System.out.println(stack.size());
	}
}
