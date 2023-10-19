import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			
			String line = st.nextToken();
			
			int length = line.length();
			
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < R; j++) {
					sb.append(line.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);		
	}
}
