import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int cnt = Integer.parseInt(in.readLine());
			histo(cnt, sb);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void histo(int cnt, StringBuilder sb) {
		
		for(int i = 0; i < cnt; i++) {
			sb.append("=");
		}
	}
}
