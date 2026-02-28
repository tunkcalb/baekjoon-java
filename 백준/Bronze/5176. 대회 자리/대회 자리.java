import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] seats = new boolean[M + 1];
			int cnt = 0;
			for(int p = 0; p < P; p++) {
				int idx = Integer.parseInt(br.readLine());
				if(seats[idx]) cnt++;
				seats[idx] = true;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
