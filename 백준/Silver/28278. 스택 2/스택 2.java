import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(num == 2) {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else sb.append(stack.pop()).append("\n");
			}
			else if (num == 3) {
				sb.append(stack.size()).append("\n");
			}
			else if (num == 4) {
				if(stack.isEmpty()) {
					sb.append(1).append("\n");
				}
				else sb.append(0).append("\n");
			}
			else {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else sb.append(stack.peek()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
