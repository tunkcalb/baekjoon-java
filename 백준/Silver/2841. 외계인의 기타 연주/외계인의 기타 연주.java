import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Stack<Integer>[] stack = new Stack[6 + 1];
		
		for(int i = 1; i <= 6; i++) {
			stack[i] = new Stack<>();
		}
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			while(!stack[n].isEmpty() && stack[n].peek() > m) {
				stack[n].pop();
				cnt++;
			}
			
			if(stack[n].empty() || stack[n].peek() < m) {
				stack[n].push(m);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
