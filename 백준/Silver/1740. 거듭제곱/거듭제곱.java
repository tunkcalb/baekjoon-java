import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(in.readLine());
		
		Queue<Long> q = new LinkedList<>(); 
		while(N != 0) {
			q.offer(N % 2);
			N /= 2;
		}
		
		long ans = 0;
		long num = 1;
		
		while(!q.isEmpty()) {
			ans += q.poll() * num;
			num *= 3;
		}
		System.out.println(ans);
	}
}
