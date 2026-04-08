import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine());
		
		int s = 0;
		int cnt = 0;
		Set<Integer> check = new HashSet<>();
		
		while(true) {
			cnt++;
			s *= 10;
			s += 1;
			s %= N;
			
			if(s == 0) {
				System.out.println(cnt);
				return;
			}
			
			if(check.contains(s)) {
				System.out.println(-1);
				return;
			}
			check.add(s);
		}
	}
}
