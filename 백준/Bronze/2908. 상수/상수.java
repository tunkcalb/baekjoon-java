import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		String newA = "";
		String newB = "";
		for(int i = 2; i >= 0; i--) {
			newA += a.charAt(i);
			newB += b.charAt(i);
		}
		
		int A = Integer.parseInt(newA);
		int B = Integer.parseInt(newB);
		
		System.out.println(Math.max(A, B));
	}
}
