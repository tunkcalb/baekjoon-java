import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int add = Integer.parseInt(in.readLine());
		
		int n = 60;
		
		h += add/n;
		
		m += add%n;
		
		h += m/n;
		m %= n;
		
		h %= 24;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(h).append(" ").append(m);
		
		System.out.println(sb);
	}
}
