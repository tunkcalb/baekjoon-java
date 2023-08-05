import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			
			if(num == 0) stack.pop();
			else stack.push(num);
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
		
	}
}
