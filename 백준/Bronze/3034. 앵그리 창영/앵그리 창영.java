import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n <= W) {
				sb.append("DA").append("\n");
			} else if (n <= H) {
				sb.append("DA").append("\n");
			} else if (n <= Math.sqrt(Math.pow(W,  2) + Math.pow(H, 2))) {
				sb.append("DA").append("\n");
			} else sb.append("NE").append("\n");
		}
		
		System.out.println(sb);
	}
}
