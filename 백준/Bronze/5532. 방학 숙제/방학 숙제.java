import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(in.readLine());
		int A = Integer.parseInt(in.readLine());
		int B = Integer.parseInt(in.readLine());
		int C = Integer.parseInt(in.readLine());
		int D = Integer.parseInt(in.readLine());
		
		
		int day = 0; 
		
		while(true) {
			day += 1;
			if(A - C * day <= 0 && B - D * day <= 0) break;
		}
		System.out.println(L - day);
	}
}
