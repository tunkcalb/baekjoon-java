import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) {
				System.out.println(sb);
				return;
			}
			
			a *= a;
			b *= b;
			c *= c;

			if(a + b == c || b + c == a || c + a == b) {
				sb.append("right").append("\n");
			}
			else {
				sb.append("wrong").append("\n");
			}
		}
		
	}
}
