import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int i = 1;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(l == 0 && p == 0 && v == 0) break;
			
			int sum = l * (v / p) + Math.min(l, v % p);
			sb.append("Case " + i++ + ": " + sum + "\n");
		}
		System.out.println(sb);
	}
}
