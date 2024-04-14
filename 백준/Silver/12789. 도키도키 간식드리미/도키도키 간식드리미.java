import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		int idx = 1;
		for (int num : nums) {
			if (num == idx) {
				idx++;
				continue;
			} else {
				if(!stack.isEmpty() && stack.peek() == idx) {
					while(idx != N && !stack.isEmpty()) {
						if(stack.peek() == idx) {
							stack.pop();
							idx++;
						}
						else break;
					}
				}	
				stack.add(num);					
			}
		}
		int len = stack.size();
		for(int i = 0; i < len; i++) {
			if(stack.peek() == idx) {
				stack.pop();
				idx++;
			}
			else break;
		}
		if(!stack.isEmpty()) System.out.println("Sad");
		else  System.out.println("Nice");
	}
}
