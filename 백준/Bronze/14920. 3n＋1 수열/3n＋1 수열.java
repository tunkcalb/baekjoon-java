import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int now = N;
		int next = now;
		
		int cnt = 1;
		while(now != 1) {
			if(now % 2 == 0) {
				next /= 2;
			}
			else {
				next = (3 * now) + 1;
			}

			now = next;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
