import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] num = new boolean[31];
		
		for(int i = 0; i < 28; i++) {
			int N = Integer.parseInt(in.readLine());
			num[N] = true;
		}
		
		for(int i = 1; i <= 30; i++) {
			if(!num[i]) System.out.println(i);
		}
		
	}
}
