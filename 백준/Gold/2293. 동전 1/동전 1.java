import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int cnt;
	static int[] coin;
	static int[] DP;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coin = new int[n];
		DP = new int[k + 1];
		DP[0] = 1;
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
			for(int j = coin[i]; j <= k; j++) {
				DP[j] += DP[j - coin[i]];
			}
		}
		
		System.out.println(DP[k]);
		
	}
}