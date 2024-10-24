import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		
		if(a + b + c != 180) {
			System.out.println("Error");
		}
		else if(a == 60 && b == 60 && c == 60){
			System.out.println("Equilateral");
		}
		else if(a == b || b == c || c == a) {
			System.out.println("Isosceles");
		}
		else {
			System.out.println("Scalene");
		}
	}
}
