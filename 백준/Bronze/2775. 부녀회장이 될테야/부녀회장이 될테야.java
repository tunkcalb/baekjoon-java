import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			
			int k = Integer.parseInt(in.readLine()) + 1;
			int n = Integer.parseInt(in.readLine());
			
			int[][] people = new int[k + 1][n + 1];
			for(int i = 0; i <= n; i++) {
				people[0][i] = 1;
			}
			
			for(int i = 1; i <= k; i++) {
				for(int j = 1; j <= n; j++) {
					people[i][j] = people[i][j - 1] + people[i - 1][j];
				}
			}			
			System.out.println(people[k][n]);
		}
	}
}
