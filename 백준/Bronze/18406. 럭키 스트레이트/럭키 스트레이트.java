import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int aSum = 0;
		int bSum = 0;
		
		int len = line.length();
		
		for(int i = 0; i < len / 2; i++) {
			aSum += line.charAt(i) - '0';
		}
		
		for(int i = len / 2; i < len; i++) {
			bSum += line.charAt(i) - '0';
		}
		
		if(aSum == bSum) {
			System.out.println("LUCKY");
		}
		else {
			System.out.println("READY");
		}
	}
}
