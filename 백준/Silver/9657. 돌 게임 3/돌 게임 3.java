import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String ans = "";
		
		if(N % 7 == 0 || N % 7 == 2) {
			ans = "CY";
		}
		else {
			ans = "SK";
		}
		System.out.println(ans);
	}
}
