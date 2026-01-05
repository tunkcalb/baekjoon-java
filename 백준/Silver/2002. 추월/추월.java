import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<String> in = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			in.offer(br.readLine());
		}
		
		Queue<String> out = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			out.offer(br.readLine());
		}
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String now = out.poll();
			
			if(in.peek().equals(now)) {
				in.poll();
			}
			else {
				cnt++;
				in.remove(now);
			}
		}
		
		System.out.println(cnt);
	}
}
