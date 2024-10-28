import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(in.readLine());
		int n = 1;
		int cnt = 0;
		
		while(n < k) n *= 2;
		
		StringBuilder sb = new StringBuilder();
		sb.append(n).append(" ");
		
		while(k > 0) {
			if(k >= n) k -= n;
			else {
				n /= 2;
				cnt++;
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}
}
