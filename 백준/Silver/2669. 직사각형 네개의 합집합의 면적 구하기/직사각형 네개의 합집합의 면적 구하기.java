import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 4;
		
		int size = 100;
		
		boolean[][] map = new boolean[size + 1][size + 1];
		
		int ans = 0;
		for(int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					if(!map[i][j]) {
						map[i][j] = true;
						ans++;
					}
				}
			}
			
		}
		System.out.println(ans);
	}
}
