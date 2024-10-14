import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(N != 0 && M != 0) {
			int[] G = new int[N];
			int[] Y = new int[M];
			
			for(int i = 0; i < N; i++) {
				G[i] = Integer.parseInt(in.readLine());
			}
			
			for(int i = 0; i < M; i++) {
				Y[i] = Integer.parseInt(in.readLine());
			}
			int g = 0;
			int y = 0;
			
			int cnt = 0;
			
			while(g < N && y < M) {
				if(G[g] == Y[y]) {
					cnt++;
					g++;
					y++;
				}
				else if (G[g] < Y[y]) g++;
				else y++;
			}
			
			System.out.println(cnt);
			
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}		
	}
}
