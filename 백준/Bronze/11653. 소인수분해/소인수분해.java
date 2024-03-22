import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		while(N != 1) {
			for(int i = 2; i <= N; i++) {
				if(N % i == 0) {
					System.out.println(i);
					N /= i;
					break;
				}
			}
		}
		
	}
}
