import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int mon = Integer.parseInt(in.readLine());
		int day = Integer.parseInt(in.readLine());
		
		String ans = "";
		if(mon < 2) ans = "Before";
		if(mon > 2) ans = "After";
		if(mon == 2) {
			if(day < 18) ans = "Before";
			if(day > 18) ans = "After";
			if(day == 18) ans = "Special";
		}
		System.out.println(ans);
	}
}
