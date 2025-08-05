import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
						
			int idx = 0;
			while(n > 0) {
				if(n % 2 == 1) {
					sb.append(idx).append(" ");
				}
				n /= 2;
				idx++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
