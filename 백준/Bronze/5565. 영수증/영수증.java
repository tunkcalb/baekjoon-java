import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < 9; i++) {
			sum -= Integer.parseInt(in.readLine());
		}
		
		System.out.println(sum);
	}
}
