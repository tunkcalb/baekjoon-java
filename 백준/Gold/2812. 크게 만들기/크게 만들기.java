import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = K;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		String line = br.readLine();
		for(int i = 0; i < N; i++) {
			int now = line.charAt(i) - '0';
			if(stack.isEmpty()) stack.push(now);
			else {
				while(!stack.isEmpty() && stack.peek() < now && cnt > 0) {
					stack.pop();
					cnt--;
				}
				stack.push(now);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N - K; i++) {
			sb.append(stack.removeLast());
		}
		System.out.println(sb);
	}
}
