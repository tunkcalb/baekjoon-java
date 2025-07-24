import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		
		BigInteger N = new BigInteger(num, 2);
		
		String ans = N.toString(8);
		
		System.out.println(ans);
	}
}
