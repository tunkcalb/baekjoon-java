import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringBuilder sb = new StringBuilder();
		while( ( line = br.readLine() ) != null ) {
			int up = 0;
			int down = 0;
			int num = 0;
			int blank = 0;
			
			for(int i = 0; i < line.length(); i++) {
				char now = line.charAt(i);
				
				if(now == ' ') {
					blank++;
				} else if (now >= '0' && now <= '9') {
					num++;
				} else if (now >= 'a' && now <= 'z') {
					down++;
				} else {
					up++;
				}
			}
			
			sb.append(down).append(" " ).append(up).append(" ").append(num).append(" ").append(blank).append("\n");
		}
		
		System.out.println(sb);
	}
}
