import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> A = new LinkedList<>();
		st = new StringTokenizer(in.readLine());
		Queue<Integer> B = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			A.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		while(!A.isEmpty()) {
			time++;
			Integer now = A.peek();
			if(L - now >= 0) {
				A.poll();
				L -= now;
				B.offer(now);
			}
			else {
				B.offer(0);
			}
			if(B.size() == w) {
				L += B.poll();
			}
		}
		System.out.println(time + w);
	}
}
