import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dc = {-1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = 3;
		
		int[][] dp_min = new int[N + 1][M];
		int[][] dp_max = new int[N + 1][M];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				dp_min[i][j] = dp_min[i - 1][j] + num;
				dp_max[i][j] = dp_max[i - 1][j] + num;
				
				if(i == 0) continue;
				for(int k: dc) {
					if(j + k < 0 || j + k >= 3) continue;
					dp_min[i][j] = Math.min(dp_min[i][j], dp_min[i - 1][j + k] + num);
                    dp_max[i][j] = Math.max(dp_max[i][j], dp_max[i - 1][j + k] + num);
				}
			}
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			max = Math.max(max, dp_max[N][i]);
			min = Math.min(min, dp_min[N][i]);
		}
		System.out.println(max + " " + min);
	}
}
