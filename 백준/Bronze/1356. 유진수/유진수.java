import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String N = in.readLine();
		int len = N.length();
		if(len == 1) {
			System.out.println("NO");
			return;
		}
		int cnt = zeroCount(N);
		if(cnt == 1) {
			System.out.println("NO");
			return;
		}
		else if(cnt >= 2) {
			System.out.println("YES");
			return;
		}
		
		int a = N.charAt(0) - '0';
		int b = 1;
		
		for(int i = 1; i < len; i++) {
			b *= N.charAt(i) - '0';
		}
		
		
		String ans = "NO";
		for(int i = 1; i < len - 1; i++) {
			if(a == b) {
				ans = "YES";
			}
			int num = N.charAt(i) - '0';
			a *= num;
			b /= num;
		}
		
		if(a == b) ans = "YES";
		
		System.out.println(ans);
	}

	private static int zeroCount(String n) {
		int cnt = 0;
		int len = n.length();
		
		for(int i = 0; i < len; i++) {
			if(n.charAt(i) == '0') {
				cnt++;
			}
		}
		return cnt;
	}
}
