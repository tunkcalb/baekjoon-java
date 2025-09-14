import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(r < e - c) {
				sb.append("advertise").append("\n");
			}
			else if(r > e - c) {
				sb.append("do not advertise").append("\n");
			}
			else {
				sb.append("does not matter").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
