import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String you = "You get ";
		String dad = " piece(s) and your dad gets ";
		String piece = " piece(s).";
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sb.append(you).append(c / v).append(dad).append(c % v).append(piece).append("\n");
		}
		
		System.out.println(sb);
	}
}
