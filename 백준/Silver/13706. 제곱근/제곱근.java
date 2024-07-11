import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger n = new BigInteger(in.readLine());
		
		BigInteger bot = BigInteger.ONE;
        BigInteger top = n;
        BigInteger mid = null;
        
        while(true) {
        	mid = bot.add(top).divide(BigInteger.TWO);
        	int result = mid.multiply(mid).compareTo(n);
        	if(result == 0) {
        		break;
        	} else if (result == 1) {
        		top = mid.subtract(BigInteger.ONE);
        	} else {
        		bot = mid.add(BigInteger.ONE);
        	}
        }
        System.out.println(mid);
	}
}
