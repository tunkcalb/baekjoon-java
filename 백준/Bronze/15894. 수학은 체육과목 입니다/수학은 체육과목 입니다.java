import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(in.readLine());
		System.out.println(4 * N);
	}
}
