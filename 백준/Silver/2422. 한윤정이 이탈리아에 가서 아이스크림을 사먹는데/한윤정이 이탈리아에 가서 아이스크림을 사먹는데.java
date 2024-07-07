import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] pairs = new boolean[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pairs[a][b] = true;
			pairs[b][a] = true;
		}
		
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				if(pairs[i][j]) continue;
				
				for(int k = j + 1; k <= N; k++) {
					if(!pairs[j][k] && !pairs[i][k]) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
