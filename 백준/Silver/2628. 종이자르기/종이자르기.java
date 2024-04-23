import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] cutCol = new int[M + 1];
		int[] cutRow = new int[N + 1];
		
		int C = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < C; i++) {
			st = new StringTokenizer(in.readLine());
			int type = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if(type == 0) {
				cutRow[idx] = 1;
			} else {
				cutCol[idx] = 1;
			}
		}
		int temp = 0;
		int maxRow = 0;
		for(int i = 1; i <= N; i++) {
			temp++;
			if (cutRow[i] == 1 || i == N) {
				maxRow = Math.max(maxRow, temp);
				temp = 0;
			}
		}
		temp = 0;
		int maxCol = 0;
		for(int i = 1; i <= M; i++) {
			temp++;
			if(cutCol[i] == 1 || i == M) {
				maxCol = Math.max(maxCol, temp);
				temp = 0;
			}
		}
		System.out.println(maxCol * maxRow);
	}
}
