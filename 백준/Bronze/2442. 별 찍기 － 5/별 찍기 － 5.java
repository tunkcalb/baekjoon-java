import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {

			for (int k = 0; k < N - i; k++) {
				sb.append(" ");
			}

			for (int k = 0; k < i * 2 - 1; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
