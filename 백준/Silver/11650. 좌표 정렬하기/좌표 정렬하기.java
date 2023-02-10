import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] board = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 2; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(board,(o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}else {
				return o1[0] - o2[0];
			}
		});
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}