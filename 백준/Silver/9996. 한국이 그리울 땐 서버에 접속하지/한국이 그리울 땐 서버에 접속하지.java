import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine(), "*");
		String start = st.nextToken();
		String end = st.nextToken();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			if(start.length() + end.length() > line.length()) {
				sb.append("NE");
			}
			else if(line.startsWith(start) && line.endsWith(end)) {
				sb.append("DA");
			}
			else sb.append("NE");
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
