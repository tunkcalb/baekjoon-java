import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				sum += Integer.parseInt(st.nextToken()) / K;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
