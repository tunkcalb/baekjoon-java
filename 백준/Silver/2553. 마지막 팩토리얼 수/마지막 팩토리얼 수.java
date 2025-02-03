import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long num = 1;
		
		for(int i = 2; i <= N; i++) {
			num *= i;
			
			while(num % 10 == 0) num /= 10;
			
			num %= 10000000;
		}
		
		System.out.println(num % 10);
	}
}
