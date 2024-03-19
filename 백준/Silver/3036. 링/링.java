import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int first = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N - 1; i++) {
			int other = Integer.parseInt(st.nextToken());
			int gcd = gcd(first, other);
			
			sb.append(first / gcd).append("/").append(other/gcd).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		
		int tmp = 0;
		
		if(b > a) {
			tmp = b;
			b = a;
			a = tmp;
		}
		
		while(b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}
}
