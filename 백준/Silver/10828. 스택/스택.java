import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			
			if(command.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(command.equals("pop")) {
				if(!stack.isEmpty()) System.out.println(stack.pop());
				else System.out.println(-1);
			}
			else if(command.equals("size")) {
				System.out.println(stack.size());
			}
			else if(command.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else System.out.println(stack.peek());
			}			
		}
	}
}