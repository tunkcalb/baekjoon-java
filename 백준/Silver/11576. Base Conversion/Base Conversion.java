import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		int num = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = m - 1; i >= 0; i--) {
			int tmp = Integer.parseInt(st.nextToken());
			num += tmp * (int) Math.pow(A, i);
		}
		
		Stack<Integer> stack = new Stack<>();
		
		while(num != 0) {
			stack.push(num % B);
			num /= B;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}
