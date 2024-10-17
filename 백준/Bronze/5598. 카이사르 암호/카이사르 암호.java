import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();

		char[] word = new char[line.length()];
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i)-3<'A') word[i] = (char)(line.charAt(i) + 23);
			else word[i] = (char)(line.charAt(i) - 3);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < line.length(); i++) {
			sb.append(word[i]);
		}
		System.out.println(sb);
	}
}
