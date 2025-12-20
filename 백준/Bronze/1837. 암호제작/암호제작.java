import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger P = new BigInteger(st.nextToken());
		BigInteger K = new BigInteger(st.nextToken());
		
		BigInteger num = new BigInteger("1");
		
		while(true) {
			if(num.compareTo(K) == 1 || num.compareTo(K) == 0) {
				System.out.println("GOOD");
				break;
			}
			num = num.add(BigInteger.ONE);
			
			if(P.remainder(num).compareTo(BigInteger.ZERO) == 0 && num.compareTo(K) == -1) {
				System.out.println("BAD " + num);
				break;
			}
		}
	}
}
