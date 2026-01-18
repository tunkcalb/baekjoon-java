import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int len = line.length();
		
		long sum = 0;
		for(int i = 0; i < len; i++) {
			int num = line.charAt(i) - '0';
			sum += Math.pow(num, 5);
		}
		
		System.out.println(sum);
	}
}
