import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		boolean[] visited = new boolean[N + 1];
		long[] fac = new long[N];
		
		fac[0] = 1;
		for(int i = 1; i < N; i++) {
			fac[i] = fac[i - 1] * i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		if(st.nextToken().equals("1")) {
			long k = Long.parseLong(st.nextToken()) - 1;
			
			for(int i = N; i > 0; i--) {
				long idx = k / fac[i - 1] + 1;
				k %= fac[i - 1];
				int index = 0;
				long cnt = 0;
				
				while(cnt != idx) {
					index++;
					if(!visited[index]) cnt++;
				}
				
				visited[index] = true;
				sb.append(index).append(" ");
			}
		}
		else {
			long k = 1;
			for(int i = N; i > 0; i--) {
				int num = Integer.parseInt(st.nextToken());
				int index = 0;
				int cnt = 0;
				while(index != num) {
					index++;
					if(!visited[index]) cnt++;
				}
				
				visited[index] = true;
				k += (cnt - 1) * fac[i - 1];
			}
			
			sb.append(k);
		}
		
		System.out.println(sb);
	}
}
