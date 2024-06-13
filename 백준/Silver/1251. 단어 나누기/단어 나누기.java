import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		int len = line.length();
		List<String> list = new ArrayList<>();
		
		for(int i = 1; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				list.add(function(line, i, j));
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	private static String function(String line, int i, int j) {
		StringBuilder s1 = new StringBuilder(line.substring(0, i));
		StringBuilder s2 = new StringBuilder(line.substring(i, j));
		StringBuilder s3 = new StringBuilder(line.substring(j));
		StringBuilder sb = new StringBuilder();
		sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
		
		return sb.toString(); 
	}
}
