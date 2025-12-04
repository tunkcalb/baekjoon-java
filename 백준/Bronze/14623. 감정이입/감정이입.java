import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger A = new BigInteger(br.readLine(), 2);
		BigInteger B = new BigInteger(br.readLine(), 2);
	
		System.out.println( A.multiply(B).toString(2));
	}
}
