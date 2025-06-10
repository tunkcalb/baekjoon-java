import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int len = line.length();
		int idx = 0;
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		while(idx < len) {
			char now = line.charAt(idx);
			if(now == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while(true) {
					sb.append(now);
					idx++;
					if(now == '>') break;
					now = line.charAt(idx);					
				}
				continue;
			}
			if(now == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(now);
				idx++;
				continue;
			}
			stack.push(now);
			idx++;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
