import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			int cnt = 0;
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == 'O') cnt++;
			}
			 
			if(cnt >= (M + 1) / 2) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
