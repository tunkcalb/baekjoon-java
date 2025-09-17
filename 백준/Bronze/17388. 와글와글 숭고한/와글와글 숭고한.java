import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		if(S + K + H >= 100) {
			sb.append("OK");
		}
		else {
			int min = Math.min(Math.min(S, K), H);
			
			if(min == S) {
				sb.append("Soongsil");
			}
			else if(min == K) {
				sb.append("Korea");
			}
			else {
				sb.append("Hanyang");
			}
		}
		
		System.out.println(sb);
	}
}
