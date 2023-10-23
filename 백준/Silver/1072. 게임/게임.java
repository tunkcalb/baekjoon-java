import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long X = Long.parseLong(st.nextToken());
		
		long Y = Long.parseLong(st.nextToken());
		
		long Z = (int) (Y * 100 / X);
		
		int ans = -1;
		
		if (Z < 99) {
			ans = (int) Math.ceil((100 * Y - X * (Z + 1)) / (double) (Z - 99));
		}
		System.out.println(ans);
	}
}
