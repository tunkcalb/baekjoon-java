import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger N = new BigInteger(br.readLine(), 2);
		
		N = N.multiply(new BigInteger("17"));
		
		System.out.println(N.toString(2));
	}
}
