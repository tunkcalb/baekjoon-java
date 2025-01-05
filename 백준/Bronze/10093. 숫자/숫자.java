import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		if(a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		StringBuilder sb = new StringBuilder();
		if(a == b) {
			sb.append(0);
		}
		else {
			sb.append(b - a - 1).append("\n");
			for(long i = a + 1; i < b; i++) {
				sb.append(i).append(" ");
			}			
		}
		System.out.println(sb);
	}
}
