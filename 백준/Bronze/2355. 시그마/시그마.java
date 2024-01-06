import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long A = Math.min(N, M);
		long B = Math.max(N, M);
		long sum = (((B + 1) * B) / 2) - (((A - 1) * A) / 2);
	
		System.out.println(sum);
	}
}
