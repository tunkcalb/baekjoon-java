import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			String name = st.nextToken();
			
			sb.append(name.charAt(0));
		}
		System.out.println(sb);
	}
}
