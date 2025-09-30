import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		if(line.charAt(1) == '0') {
			
			System.out.println(10 + Integer.parseInt(line.substring(2)));
		}
		else {
			System.out.println((line.charAt(0) - '0') + Integer.parseInt(line.substring(1)));
		}
	}
}
