import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger num = new BigInteger(br.readLine(), 8);
		
		String ans = num.toString(2);
		
		System.out.println(ans);
	}
}
