import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		long sub = y - x;
		
		if(sub == 0) {
			System.out.println(0);
			return;
		}
		
		long N = 1;
		long ans = 0;
		
		while(N * N <= sub) {
			N++;
		}
		N--;
		
		ans = 2 * N - 1;
		
		sub -= N * N;
		
		while(sub > 0) {
			for(long i = N; 1 <= i; i--) {
				if(i <= sub) {
					ans += 1;
					sub -= i;
					break;
				}
			}
		}
		System.out.println(ans);	
	}
}
