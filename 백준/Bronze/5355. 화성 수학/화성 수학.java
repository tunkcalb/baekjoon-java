import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double num = Double.parseDouble(st.nextToken());
			
			while(st.hasMoreTokens()) {
				String cal = st.nextToken();
				
				if(cal.equals("@")) {
					num *= 3;
				}
				else if(cal.equals("%")) {
					num += 5;
				}
				else if(cal.equals("#")) {
					num -= 7;
				}
			}
			sb.append(String.format("%.2f", num)).append("\n");
		}
		System.out.println(sb);
	}
}
