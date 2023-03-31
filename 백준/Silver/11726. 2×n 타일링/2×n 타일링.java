import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] DP = new int[N + 2];
		
		DP[1] = 1;
		DP[2] = 2;
		for(int i = 3; i <= N; i++) {
			DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
		}
		
		System.out.println(DP[N]);
	}
}