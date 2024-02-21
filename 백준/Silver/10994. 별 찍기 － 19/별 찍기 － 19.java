import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char stars[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		int m = 4 * n - 3;

		stars = new char[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				stars[i][j] = ' ';
			}
		}
		countingStars(0, m);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void countingStars(int start, int len) {
		if (len <= start) return;
		
		for (int i = start; i < len; i++) {
			stars[start][i] = '*';
			stars[len - 1][i] = '*';
			stars[i][start] = '*';
			stars[i][len - 1] = '*';
		}
		
		countingStars(start + 2, len - 2);
	}
}
