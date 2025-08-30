import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 9;
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int Y = 0;
			int K = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Y += Integer.parseInt(st.nextToken());
				K += Integer.parseInt(st.nextToken());
			}
			if(Y < K) {
				sb.append("Korea");
			} else if (Y > K) {
				sb.append("Yonsei");
			} else {
				sb.append("Draw");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
