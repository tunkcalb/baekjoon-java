import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		if(N == 1) {
			System.out.println(1);
		}else if(N == 2) {
			System.out.println(2);
		}else {
			int[] DP = new int[N + 1];
			
			Arrays.fill(DP, -1);
			
			DP[0] = 0;
			DP[1] = 1;
			DP[2] = 2;
			
			for(int i = 3; i <= N; i++) {
				DP[i] = (DP[i - 1] + DP[i - 2]) % 15746;
			}
			
			System.out.println(DP[N]);
		}
	}
}