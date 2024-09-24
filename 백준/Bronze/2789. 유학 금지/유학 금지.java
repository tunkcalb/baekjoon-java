import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] cambridge = { "C", "A", "M", "B", "R", "I", "D", "G", "E" };
		String line = in.readLine();
		
		for(String camb : cambridge) {
			line = line.replace(camb, "");
		}
		System.out.println(line);
	}

}
