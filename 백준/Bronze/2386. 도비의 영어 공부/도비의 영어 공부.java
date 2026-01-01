import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char alpha = st.nextToken().charAt(0);
			if(alpha == '#') break;
			int cnt = 0;
			
			while(st.hasMoreTokens()) {
				String line = st.nextToken().toLowerCase();
				int len =  line.length();
				
				for(int i = 0; i < len; i++) {
					if(line.charAt(i) == alpha) cnt++; 
				}				
			}
			sb.append(alpha).append(" ");
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
