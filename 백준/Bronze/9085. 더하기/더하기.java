import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
