import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			sb.append(i + ". " + in.readLine()).append("\n");
		}
		System.out.println(sb);
	}
}
