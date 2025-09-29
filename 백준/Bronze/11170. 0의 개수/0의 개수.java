import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int i = N; i <= M; i++) {
				String num = String.valueOf(i);
				for(int j = 0; j < num.length(); j++) {
					if(num.charAt(j) == '0') cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
