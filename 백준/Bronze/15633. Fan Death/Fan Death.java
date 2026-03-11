import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for(int i = 1; i * i <= n; i++) {
			if(n % i == 0) {
				sum += i;
				if(i != n / i) sum += n / i;
			}
		}
		
		sum = sum * 5 - 24;
		
		System.out.println(sum);
	}
}
