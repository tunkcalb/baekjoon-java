import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		if(a == b + c) {
			sb.append(a).append("=").append(b).append("+").append(c);
		}
		else if(a == b - c) {
			sb.append(a).append("=").append(b).append("-").append(c);
		}
		else if(a == b * c) {
			sb.append(a).append("=").append(b).append("*").append(c);
		}
		else if(a == b / c) {
			sb.append(a).append("=").append(b).append("/").append(c);
		}
		else if(a + b == c) {
			sb.append(a).append("+").append(b).append("=").append(c);
		}
		else if(a - b == c) {
			sb.append(a).append("-").append(b).append("=").append(c);
		}
		else if(a * b == c) {
			sb.append(a).append("*").append(b).append("=").append(c);
		}
		else if(a / b == c) {
			sb.append(a).append("/").append(b).append("=").append(c);
		}
		
		System.out.println(sb);
	}
}
