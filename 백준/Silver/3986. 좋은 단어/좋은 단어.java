import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			String line = in.readLine();
			int len = line.length();
			
			for(int j = 0; j < len; j++) {
				char now = line.charAt(j);
				if(stack.isEmpty() || stack.peek() != now) {
					stack.push(now);
				}
				else if (stack.peek() == now) {
					stack.pop();
				}
			}
			if(stack.isEmpty()) cnt++;
		}
		System.out.println(cnt);
	}
}
