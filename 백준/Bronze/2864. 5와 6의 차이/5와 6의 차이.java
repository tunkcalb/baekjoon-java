import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		System.out.print(Integer.parseInt(A.replaceAll("6", "5")) + Integer.parseInt(B.replaceAll("6", "5")));
		System.out.print(" ");
		System.out.print(Integer.parseInt(A.replaceAll("5", "6")) + Integer.parseInt(B.replaceAll("5", "6")));
		
	}
}
