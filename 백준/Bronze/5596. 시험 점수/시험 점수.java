import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = 4;
		int mg = 0;
		int ms = 0;
		for(int i = 0; i < N; i++) {
			mg += Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			ms += Integer.parseInt(st.nextToken());
		}
		if(mg > ms) System.out.println(mg);
		else System.out.println(ms);
	}
}
