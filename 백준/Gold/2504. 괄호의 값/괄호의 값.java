import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		boolean isValid = true;
		long ans = 0;
		int val = 1;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '(') {
				stack.add(line.charAt(i));
				val *= 2;
			}
			if(line.charAt(i) == '[') {
				stack.add(line.charAt(i));
				val *= 3;
			}
			if(line.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					isValid = false;
					break;
				}
				if(line.charAt(i - 1) == '(') {
					ans += val;	
				}
				stack.pop();
				val /= 2;
			}
			else if (line.charAt(i) == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					isValid = false;
					break;
				}
				if(line.charAt(i - 1) == '[') {
					ans += val;
				}
				stack.pop();
				val /= 3;
			}
		}
		
		if(isValid == false || !stack.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(ans);
		}
	}
}
