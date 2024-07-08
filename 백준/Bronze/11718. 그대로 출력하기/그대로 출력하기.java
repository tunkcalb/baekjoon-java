import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = in.readLine();
			
			if(line == null) break;
			
			System.out.println(line);
		}
		
	}
}
