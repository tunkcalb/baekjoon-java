import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine();
		String B = in.readLine();
		String C = in.readLine();
		int a = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
		int b = Integer.parseInt(A + B) - Integer.parseInt(C);
		System.out.println(a);
		System.out.println(b);
	}
}
