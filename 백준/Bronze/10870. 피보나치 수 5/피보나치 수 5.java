import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		int[] fibo  = new int[N + 1];
		
		if(N == 0) {
			System.out.println(0);
		}
		else {
			fibo[0] = 0;
			fibo[1] = 1;
			
			for (int i = 2; i <= N; i++) {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
			
			System.out.println(fibo[N]);
			
		}
	}
}