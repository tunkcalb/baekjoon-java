import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		int[][] map = new int[n + 1][n + 1];
		
		int INF = 100000000;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		}
		
		for(int t = 0; t < m; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			map[i][j] = Math.min(val, map[i][j]);
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == INF) map[i][j] = 0;
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
