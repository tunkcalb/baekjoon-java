import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < N; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append("Pairs for ").append(n).append(": ");
			int cnt = 0;
			for(int i = 1; i <= n / 2; i++) {
				if(n - i == n / 2) continue;
				if(cnt == 0) {
					sb.append(i).append(" ").append(n - i);
				}
				else {
					sb.append(", ").append(i).append(" ").append(n - i);
				}
				cnt++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
