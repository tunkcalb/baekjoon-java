import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N - i; j++) {
				sb.append(" ");
			}
			for(int j = 1; j <= i * 2 - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j <= i; j++) {
				sb.append(" ");
			}
			for(int j = 1; j <= (N - i) * 2 - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
