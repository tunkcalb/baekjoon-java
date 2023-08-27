import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num = 0;
		
		num += 6916 * E;
		num += 4845 * S;
		num += 4200 * M;
		
		num %= 7980;
		if(num == 0) {
			num = 7980;
		}
		System.out.println(num);
	}
}
