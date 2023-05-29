import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
		
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		String bomb = in.readLine();
		
		int lineSize = line.length();
		int bombSize = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < lineSize; i++) {
			stack.push(line.charAt(i));
			
			if(stack.size() >= bombSize) {
				boolean isBomb = true;
				for(int j = 0; j < bombSize; j++) {
					if(stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				
				if(isBomb) {
					for(int j = 0; j < bombSize; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Character c : stack) {
			sb.append(c);
		}
		if(sb.length() == 0) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb.toString());
		}
	}
}
