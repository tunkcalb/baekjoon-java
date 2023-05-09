import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(M - GCD(N, M));
	}

	private static int GCD(int n, int m) {
		
		int num = n;
		if(num < m) num = m;
		while(num > 1) {
			if(n % num == 0 && m % num == 0) {
				return num;
			}
			num--;
		}
		return 1;
	}
}
