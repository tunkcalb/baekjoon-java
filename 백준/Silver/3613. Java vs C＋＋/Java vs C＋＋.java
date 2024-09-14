import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		StringBuilder sb = new StringBuilder();

		if(line.contains("_")) {
			for(int i = 0; i < line.length(); i++) {
				if(Character.isUpperCase(line.charAt(i)) || line.charAt(line.length() - 1) == '_' || line.charAt(0) == '_') {
					sb = new StringBuilder("Error!");
					break;
				}
				if(line.charAt(i) == '_' && i != line.length() - 1) {
					if(line.charAt(i + 1) == '_') {
						sb = new StringBuilder("Error!");
						break;
					}
					if(Character.isUpperCase(line.charAt(i + 1))) {
						sb = new StringBuilder("Error!");
						break;
					}
					sb.append(Character.toUpperCase(line.charAt(i + 1)));
					i++;
				} else sb.append(line.charAt(i));
			}
		}
		else {
			for(int i = 0; i < line.length(); i++) {
				if(Character.isUpperCase(line.charAt(0))) {
					sb = new StringBuilder("Error!");
					break;
				}
				if(Character.isUpperCase(line.charAt(i))) {
					sb.append("_").append(Character.toLowerCase(line.charAt(i)));
				}
				else sb.append(line.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
