import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char letter = br.readLine().charAt(0);
		
		System.out.println(letter - '가' + 1);
	}
}
