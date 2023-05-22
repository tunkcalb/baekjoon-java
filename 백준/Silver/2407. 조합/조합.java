import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger num1 = BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;
		
		for(int i = 0; i < m; i++) {
			num1 = num1.multiply(new BigInteger(String.valueOf(n - i)));
			num2 = num2.multiply(new BigInteger(String.valueOf(m - i)));
		}
		
		System.out.println(num1.divide(num2));
		
	}
}
