import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int D, P;
	static int[][] board;
	static int[] DP;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		board = new int[P + 1][2];
		DP = new int [D + 1]; 
		DP[0] = Integer.MAX_VALUE;
		
		for(int i = 1; i <= P; i++) {
			st= new StringTokenizer(in.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			for(int j = D; j >= L; j--) {
				DP[j] = Math.max(DP[j], Math.min(C, DP[j - L]));
			}
		}
		
		System.out.println(DP[D]);
	}
}
