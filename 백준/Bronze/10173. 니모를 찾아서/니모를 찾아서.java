import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String line = br.readLine();
			
			if(line.equals("EOI")) break;
			line = line.toLowerCase();
			
			if(line.contains("nemo")) {
				sb.append("Found");
			}
			else {
				sb.append("Missing");
			}

			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
