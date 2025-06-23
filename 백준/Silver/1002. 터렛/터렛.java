import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
			
			if(x1 == x2 && y1 == y2) {
				if(r1 == r2) sb.append(-1).append("\n");
				else sb.append(0).append("\n");
			}
			else {
				if(r1 + r2 < d || (r1 - r2) * (r1 - r2) > d * d) sb.append(0).append("\n");
				else if(r1 + r2 == d || (r1 - r2) * (r1 - r2) == d * d) sb.append(1).append("\n");
				else if((r1 - r2) * (r1 - r2) < d * d && (r1 + r2) * (r1+ r2) > d * d) sb.append(2).append("\n");
			}
		}
		System.out.println(sb);

    }
}
