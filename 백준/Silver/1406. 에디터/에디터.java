import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		
		String[] arr = line.split("");
		for(String s : arr) {
			left.push(s);
		}
		
		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			
			switch(command.charAt(0)) {
			case 'L':
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
			case 'D':
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
			case 'B':
				if(!left.isEmpty()) {
					left.pop();
				}
				break;
			case 'P':
				char s = command.charAt(2);
				left.push(String.valueOf(s));
				break;
			}
		}
		
		int lSize = left.size();
		
		for(int i = 0; i < lSize; i++) {
			right.push(left.pop());
		}
		
		int size = right.size();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);	
	}
}
