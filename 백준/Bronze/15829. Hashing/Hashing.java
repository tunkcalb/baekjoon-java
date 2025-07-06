import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < L; i++) {
			int num = line.charAt(i) - 'a' + 1;
			BigInteger pow = BigInteger.valueOf(31);
			sum = sum.add(pow.pow(i).multiply(BigInteger.valueOf(num)));
		}
		
		System.out.println(sum);
	}
}
