import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (true) {
				if (!stack.empty()) {
					int top = stack.peek();
					if (top > num) {
						sb.append(index.peek()).append(" ");
						stack.push(num);
						index.push(i);
						break;
					} else {
						stack.pop();
						index.pop();
					}

				}else {
					sb.append(0).append(" ");
					stack.push(num);
					index.push(i);
					break;
				}
			}
		}

		System.out.println(sb);
	}
}