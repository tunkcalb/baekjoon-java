import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		String ppap = "PPAP";
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < line.length(); i++) {
			char temp = line.charAt(i);
			
			if(temp == 'P') {
				stack.push('P');
			}
			else {
				if(stack.size() >= 2 && i < line.length() - 1 && line.charAt(i + 1) == 'P') {
					stack.pop();
					stack.pop();
				}
				else {
					System.out.println("NP");
					return;
				}
			}
		}
		if(stack.size() == 1) {
			System.out.println("PPAP");
		}
		else {
			System.out.println("NP");
		}
	}
}
