import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] bugs = new int[N + 4 + 1];
		
		bugs[1] = 1;
		bugs[4] -= 1;
		for(int i = 2; i <= N; i++) {
			int cnt = bugs[i - 1];
			bugs[i] += cnt * 2;
			
			if(i % 2 == 1) {
				bugs[i + 3] -= cnt;
			}else {
				bugs[i + 4] -= cnt;
			}
		}
		System.out.println(bugs[N]);	
	}
}
