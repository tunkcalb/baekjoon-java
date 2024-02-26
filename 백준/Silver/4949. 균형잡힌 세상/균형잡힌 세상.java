import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		frame : while(true) {
			String line = in.readLine();
			if(line.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < line.length(); i++) {
				char temp = line.charAt(i);
				if(temp == '(' || temp == '[') {
					stack.push(temp);
				}
				if(temp == ')' || temp == ']') {
					if (stack.isEmpty() || (stack.peek() == '(' && temp == ']') || (stack.peek() == '[' && temp == ')')) {
						stack.push(temp);
						break;
					}
					stack.pop();
				}
			}
			if (!stack.isEmpty())
				sb.append("no").append("\n");
			else
				sb.append("yes").append("\n");
		}
		System.out.println(sb);
	}
}
