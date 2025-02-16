import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			if(K == 1) {
				sb.append(Math.abs(x - y)).append("\n");
			}
			else {
				int cnt = 0;
				while(x != y) {
					if(x < y) {
						y = (y - 2) / K + 1;
					}
					else {
						x = (x - 2) / K + 1;
					}
					cnt++;
				}
				sb.append(cnt).append("\n");
			}
		}
		System.out.println(sb);
	}
}
