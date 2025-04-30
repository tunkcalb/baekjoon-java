import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int n = m;
		int time = 0;
		if(m + T > M) {
			System.out.println(-1);
			return;
		}
		while(N > 0) {
			if(n + T <= M) {
				n += T;
				N--;
				time++;
			}else {
				n -= R;
				if(n < m) n = m;
				time++;
			}
		}
		
		System.out.println(time);
	}
}
