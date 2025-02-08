import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			String line = st.nextToken();
			
			for(int j = 0; j < line.length(); j++) {
				if(j == idx) continue;
				sb.append(line.charAt(j));
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
