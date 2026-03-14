import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			if(a1 == 0 && a2 == 0 && a3 == 0) break;
			
			if(a2 - a1 == a3 - a2) {
				int dif = a3 - a2;
				sb.append("AP").append(" ").append(a3 + dif);
			}
			else {
				int per = a2 / a1;
				sb.append("GP").append(" ").append(a3 * per);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
