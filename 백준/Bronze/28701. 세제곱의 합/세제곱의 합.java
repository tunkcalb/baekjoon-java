import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for(int i = 1; i <= N; i++) {
			sum1 += i;
			sum2 += i;
			sum3 += i * i * i;
		}
		
		sum2 *= sum2;
		
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		
	}
}
